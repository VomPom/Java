##综合噪声
####f1,v1分别为可控因子因子数和水平数####
myfunzh<-function(f1,v1){
  library(DoE.base)
  des<-oa.design(nfactors = f1,nlevels = v1,randomize = F)
  zh<-rbind(des,des)
  zh$N<-as.factor(rep(c(1,2),each=nrow(des)))
  return(zh)
}