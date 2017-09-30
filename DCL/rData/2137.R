

###表格L18.2.1.3.7
myfundesnsp1<-function(f1,f2){
  library(DoE.base)
  des<-oa.design(L18.2.1.3.7)[,c(1:f1)]
  if(f2==1){
    return(des)
  }else{
    for(i in 2:f2){
      des[which(des[,i]==3),i]=2
      des[,i]<-as.factor(des[,i])
    }
    return(des)
  }
}
