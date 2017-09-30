###拟水平法###
##应用于f1+f2<4且v1=2,v2=3的情况或者v1=3,v2=4
##v1为因子1水平数，f1为因子1个数，v2为因子2水平数，f2为因子2个数
myfundesnsp <- function(f1,v1,f2,v2){
  #install.packages("DoE.base")
  library(DoE.base)
  des <- DoE.base::oa.design(nfactors = f1+f2+1,nlevels = v2,randomize = F)[,-c(f1+f2+1)]
  if(v2==3){
    for(i in 1:f1){
      des[which(des[,i]==3),i]=2
      des[,i]<-as.factor(des[,i])
    }
  }else if(v2==4){
    for(i in 1:f1){
      des[which(des[,i]==4),i]=3
      des[,i]<-as.factor(des[,i])
    }
  }
  return(des)
}





