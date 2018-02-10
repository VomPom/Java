k=3
limit<-c(0,.8,.1,.95, .05,.50)
ndm=2
q=2

###有上下界的单形设计###
##自变量： limit:各变量的范围(行如：c(A的下界,A的上界,B的下界,B的上界,C的下界,C的上界))  
##         ndm：重心类型(可取值为0,1,2)  k：自变量个数    q:方程次数
constrmixture1<-function(limit,ndm,k,q){
  library(mixexp)
  library(AlgDesign)
  lc<-limit[2*(1:k)-1]
  uc<-limit[2*(1:k)]
  if(uc[1]==1){
    uc[1]=1.1
  }
  exvert<-Xvert(nfac=k,uc=uc,lc=lc, ndm=ndm)
  ###   只能画出三个自变量的图
  ##DesignPoints(exvert, x1lower = limit[1], x1upper =limit[2],x2lower =limit[3], x2upper =limit[4], x3lower =limit[5], x3upper =limit[6],pseudo=TRUE)
  if(q==2){
    list1<-list("试验计划表"=exvert,"简化试验计划最低试验次数"=c(choose(k,1)+choose(k,2)))
  }else if(q==3){
    list1<-list("试验计划表"=exvert,"简化试验计划最低试验次数"=c(choose(k,1)+choose(k,2)+choose(k,3)))
    ####两个未知量的三次方程####
  }
  return(list1)
}






###有恒定变量的上下界单形设计###
##自变量： limit:各变量的范围(行如：c(A的下界,A的上界,B的下界,B的上界,C的下界,C的上界))  
##         ndm：重心类型(可取值为0,1,2)  k：自变量个数    q:方程次数   m:变量总和

limit<-c(0,.8,.1,.95, .05,.50)
constrmixture3<-function(limit,ndm,k,q,m){
  library(mixexp)
  library(AlgDesign)
  limit<-limit/m
  lc<-limit[2*(1:k)-1]
  uc<-limit[2*(1:k)]
  if(uc[1]==1){
    uc[1]=1.1
  }
  exvert<-Xvert(nfac=k,uc=uc,lc=lc, ndm=ndm)
  exvert[,-(k+1)]<-exvert[,-(k+1)]*m
  ###   只能画出三个自变量的图
  ##DesignPoints(exvert, x1lower = limit[1], x1upper =limit[2],x2lower =limit[3], x2upper =limit[4], x3lower =limit[5], x3upper =limit[6],pseudo=TRUE)
  if(q==2){
    list1<-list("试验计划表"=exvert,"简化试验计划最低试验次数"=c(choose(k,1)+choose(k,2)))
  }else if(q==3){
    list1<-list("试验计划表"=exvert,"简化试验计划最低试验次数"=c(choose(k,1)+choose(k,2)+choose(k,3)))
    ####两个未知量的三次方程####
  }
  return(list1)
}


###简化试验计划函数###
##自变量：design：constrmixture1函数所作出的计划表  q:方程次数   nruns：简化后的目标试验次数
constrmixture2<-function(design,q,nruns){
  if(q==2){
    a<-paste("x",1:k,sep = "")
    for(i in 1:(k-1)){
      for(j in (i+1):k){
        b<-paste(a[i],a[j],sep = ":")
        a<-c(a,b)
      }
    }
    a<-c("-1",a)
    a<-paste(a,collapse = "+")
    a<-as.formula(paste0("~",a))
  }else if(q==3){
    a<-paste("x",1:k,sep = "")
    for(i in 1:(k-1)){
      for(j in (i+1):k){
        b<-paste(a[i],a[j],sep = ":")
        a<-c(a,b)
      }
    }
    for(i in 1:(k-2)){
      for(j in (i+1):(k-1)){
        for(n in (j+1):k){
          b<-paste(a[i],a[j],a[n],sep = ":")
          a<-c(a,b)
        }
      }
    }
    a<-c("-1",a)
    a<-paste(a,collapse = "+")
    a<-as.formula(paste0("~",a))
  }
  desMix <- optFederov(a,data = design, nTrials = nruns)
  return(desMix)
}






library(daewr)
data(polvdat)
table<-polvdat
q=3
limit<-c(0,.8,.1,.95, .05,.50)
p=1
###有上下界的单形设计的方差分析###
##自变量： table:试验结果 q：方程次数  limit:各变量的范围(行如：c(A的下界,A的上界,B的下界,B的上界))
##         p:望大望小特性(1为望大，-1为望小)
mixtureanalyze<-function(table,q,limit,p){
  library(mixexp)
  library(daewr)
  k=ncol(table)-2
  lc<-limit[2*(1:k)-1]
  uc<-limit[2*(1:k)]
  m=ceiling(sum(lc-uc)/(sum(lc)+limit[2*k+1]-1))
  colnames(table)<-c(paste("x",1:(k+1),sep = ""),"y")
  analyze<-MixModel(table, "y",paste("x",1:(k+1),sep = ""),2^(q-1))
  
  pdf(file="constrained mixture.pdf")
  MixturePlot(des = table, mod = 2^(q-1), lims=limit, constrts=TRUE, pseudo=TRUE)
  dev.off()
  ##start<-(limit[seq(1,length(limit),by=2)]+limit[seq(2,length(limit),by=2)])/2
  start<-lc+(uc-lc)/m
  prod<-function(x) {
    l<-paste("x",1:(k+1),sep="")
    old<-data.frame(x1=x[1])
    if(k>1){
      for(i in 2:k){
        new<-data.frame(A=x[i])
        old<-cbind(old,new)
      }
    }
    old<-cbind(old,data.frame(A=1-sum(old)))
    names(old)<-l
    predict(analyze,old,interval = "none")
  }
  ui<-matrix(0,2*(k+1),k)
  for(i in 1:k){
    ui[(2*i-1),i]<-1
    ui[2*i,i]<--1
    ui[2*k+1,i]<-1
    ui[2*k+2,i]<--1
  }
  b<-1-limit[2*k+2]
  limit[2*k+2]<-1-limit[2*k+1]
  limit[2*k+1]<-b
  for(i in 1:length(limit)){
    limit[i]=limit[i]*(-1)^(i+1)
  }
  ci<-limit
  if(p==1){
    result<-constrOptim(start,prod,NULL,ui,ci,control = list(fnscale = -1))
  }else if(p==-1){
    result<-constrOptim(start,prod,NULL,ui,ci)
  }
  result$par<-round(c(result$par,1-sum(result$par)),3)
  return(list("回归分析"=MixModel(table, "y",paste("x",1:(k+1),sep = ""),2^(q-1)),最优化=result))
}
mixtureanalyze(table,q=3,limit,p=1)



###望目特性的方差分析###
##         m为目标值
mixtureanalyze<-function(table,q,limit,m){
  library(mixexp)
  library(daewr)
  k=ncol(table)-2
  lc<-limit[2*(1:k)-1]
  uc<-limit[2*(1:k)]
  m=ceiling(sum(lc-uc)/(sum(lc)+limit[2*k+1]-1))
  colnames(table)<-c(paste("x",1:(k+1),sep = ""),"y")
  analyze<-MixModel(table, "y",paste("x",1:(k+1),sep = ""),2^(q-1))
  
  pdf(file="constrained mixture.pdf")
  MixturePlot(des = table, mod = 2^(q-1), lims=limit, constrts=TRUE, pseudo=TRUE)
  dev.off()

  start<-lc+(uc-lc)/m
  prod<-function(x) {
    l<-paste("x",1:(k+1),sep="")
    old<-data.frame(x1=x[1])
    if(k>1){
      for(i in 2:k){
        new<-data.frame(A=x[i])
        old<-cbind(old,new)
      }
    }
    old<-cbind(old,data.frame(A=1-sum(old)))
    names(old)<-l
    predict(analyze,old,interval = "none")
  }
  ui<-matrix(0,2*(k+1),k)
  for(i in 1:k){
    ui[(2*i-1),i]<-1
    ui[2*i,i]<--1
    ui[2*k+1,i]<-1
    ui[2*k+2,i]<--1
  }
  b<-1-limit[2*k+2]
  limit[2*k+2]<-1-limit[2*k+1]
  limit[2*k+1]<-b
  for(i in 1:length(limit)){
    limit[i]=limit[i]*(-1)^(i+1)
  }
  ci<-limit
  result<-constrOptim(start,prod,NULL,ui,ci)
  result$par<-round(c(result$par,1-sum(result$par)),3)
  return(list("回归分析"=MixModel(table, "y",paste("x",1:(k+1),sep = ""),2^(q-1)),最优化=result))
}
mixtureanalyze(table,q=3,limit,m=10)




limit<-c(0.153846,0.246154,0.153846,0.246154,0,1)
design<-constrmixture1(limit,ndm=1,k=3,q=2)
design<-design$试验计划表
design<-rbind(design,design)
design<-design[-c(14:18),]
design$y<-c(0.26,0.62,0.23,0.33,0.27,0.3,0.39,0.31,0.34,0.3,0.68,0.23,0.36)
design<-design[,-4]
mixtureanalyze(design,2,limit,1)



design<-design[-c(14:18),]
design$y<-c(0.26,0.62,0.23,0.33,0.27,0.3,0.39,0.31,0.34,0.3,0.68,0.23,0.36)

