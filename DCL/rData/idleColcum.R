#自变量有：f1为2水平因子个数   f2为3水平因子个数
myfunfx<-function(f1,f2){
  library(DoE.base)
  if(f1+f2*2+2<=7){
    des<-oa.design(L8.2.7,nfactors = f1+f2*2+2,nlevels = 2,randomize = F)
    des<-des[,-ncol(des)]
    n<-ncol(des)
    for(i in 1:f2){
      des[which(des[,2*i]==1&des[,2*i+1]==1),n+i]<-1
      des[which(des[,2*i]==1&des[,2*i+1]==2),n+i]<-2
      des[which(des[,2*i]==2&des[,2*i+1]==1),n+i]<-3
      des[which(des[,2*i]==2&des[,2*i+1]==2),n+i]<-2
      des[,n+i]<-as.factor(des[,n+i])
    }
    des<-des[,-c(2:(f2*2+1))]
  }else{
    des<-oa.design(L16.2.15,nfactors = f1+f2*2+2,nlevels = 2,randomize = F)
    des<-des[,-ncol(des)]
    n<-ncol(des)
    for(i in 1:f2){
      des[which(des[,2*i]==1&des[,2*i+1]==1),n+i]<-1
      des[which(des[,2*i]==1&des[,2*i+1]==2),n+i]<-2
      des[which(des[,2*i]==2&des[,2*i+1]==1),n+i]<-3
      des[which(des[,2*i]==2&des[,2*i+1]==2),n+i]<-2
      des[,n+i]<-as.factor(des[,n+i])
    }
    des<-des[,-c(2:(f2*2+1))]
  }
  colnames(des)<-c("赋闲列",LETTERS[1:(ncol(des)-1)])
  names(des$A)<-c("赋闲列")
  return(des)
}

