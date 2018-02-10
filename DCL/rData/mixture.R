
#####表格设计#####
## 自变量：k为因子个数，q为方程次数##
###单形格子设计###
  griddesign<-function(k,q){
    library(mixexp)
    design<-SLD(k,q)
    # design<-as.matrix(design)
    ##DesignPoints(des)##
   return(design)
  }



##有恒定变量##   m为可变变量之和
   griddesign1<-function(k,q,m){
    library(mixexp)
    design<-SLD(k,q)
    design<-design/m
    ##DesignPoints(des)##
   return(design)
  }
###单形重心设计###
  centerdesign<-function(k){
    library(mixexp)
    design<-SCD(k)
    ##DesignPoints(des)##
    return(design)
  }


###有恒定变量###
  centerdesign1<-function(k,m){
   library(mixexp)
    design<-SCD(k)
    design<-design/m
    ##DesignPoints(des)##
    return(design)
  }
###有下界的单形格子设计###
  lowergriddesign<-function(k,q,lower){
    library(mixexp)
    design<-SLD(k,q)
    for(i in 1:k){
      design[,i]<-lower[i]+(1-sum(lower))*design[,i]
    }
    ##DesignPoints(des)##
    return(design)
  }

##有恒定变量##
  lowergriddesign1<-function(k,q,lower,m){
    library(mixexp)
    design<-SLD(k,q)
    for(i in 1:k){
      design[,i]<-lower[i]+(m-sum(lower))*design[,i]
    }
    ##DesignPoints(des)##
    return(design)
  }

###有下界的单形重心设计###
  lowercenterdesign<-function(k,lower){
    library(mixexp)
    design<-SCD(k)
    for(i in 1:k){
      design[,i]<-lower[i]+(1-sum(lower))*design[,i]
    }
    ##DesignPoints(des)##
    return(design)
  }
  
##有恒定变量##
  lowercenterdesign<-function(k,lower,m){
    library(mixexp)
    design<-SCD(k)
    for(i in 1:k){
      design[,i]<-lower[i]+(m-sum(lower))*design[,i]
    }
    ##DesignPoints(des)##
    return(design)
  }
  
###数据分析###
  ##自变量：table:数据表格  q：方程次数  p：望大望小特性，p=1为望大，p=-1为望小##

q=2
table<-read.csv("pest.csv",header=T)
mixtureanalyze<-function(table,q,p){
  library(mixexp)
  library(daewr)
  k=ncol(table)-2
  colnames(table)<-c(paste("x",1:(k+1),sep = ""),"y")
  analyze<-MixModel(table, "y",paste("x",1:(k+1),sep = ""),2^(q-1))
  pdf(file="mixture.pdf")
  MixturePlot(des = table,mod =2^(q-1) )
  EffPlot(des=table,mod=2^(q-1),dir=1)
  dev.off()
  start<-rep(1/(k+1),k)
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
  ci<-rep(c(0,-1),k+1)
  if(p==1){
    result<-constrOptim(start,prod,NULL,ui,ci,control = list(fnscale = -1))
  }else if(p==-1){
    result<-constrOptim(start,prod,NULL,ui,ci)
  }
  result$par<-round(c(result$par,1-sum(result$par)),3)
  return(list("回归分析"=MixModel(table, "y",paste("x",1:(k+1),sep = ""),2^(q-1)),"最优化"=result))
}
mixtureanalyze(table,q=2,p=-1)




###望目特性数据分析###
##自变量：table:数据表格  q：方程次数  m为目标值##
setwd("D:/data")
q=2
table<-read.csv("pest.csv",header=T)
mixtureanalyze<-function(table,q,m){
  library(mixexp)
  library(daewr)
  k=ncol(table)-2
  colnames(table)<-c(paste("x",1:(k+1),sep = ""),"y")
  analyze<-MixModel(table, "y",paste("x",1:(k+1),sep = ""),2^(q-1))
  pdf(file="mixture.pdf")
  MixturePlot(des = table,mod =2^(q-1) )
  EffPlot(des=table,mod=2^(q-1),dir=1)
  dev.off()
  start<-rep(1/(k+1),k)
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
    k1<-predict(analyze,old,interval = "none")
    (k1-m)^2
  }
  ui<-matrix(0,2*(k+1),k)
  for(i in 1:k){
    ui[(2*i-1),i]<-1
    ui[2*i,i]<--1
    ui[2*k+1,i]<-1
    ui[2*k+2,i]<--1
  }
  ci<-rep(c(0,-1),k+1)
  result<-constrOptim(start,prod,NULL,ui,ci)
  result$par<-round(c(result$par,1-sum(result$par)),3)
  return(list("回归分析"=MixModel(table, "y",paste("x",1:(k+1),sep = ""),2^(q-1)),"最优化"=result))
}
mixtureanalyze(table,q=2,m=10)

