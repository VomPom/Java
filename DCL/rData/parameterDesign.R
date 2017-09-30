##一般参数设计
myfuncs<-function(f1,v1,f2,v2){
        library(DoE.base)
        a<-oa.design(nfactors = f1,nlevels = v1,randomize = F)
        b<-oa.design(nfactors = f2,nlevels = v2,randomize = F)
        colnames(b)<-paste("x",1:f2,sep = "")
        c <- cross.design(a,b,randomize = F)
        return(c)
  }