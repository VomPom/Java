
##当因子数f1<12时，使用此函数##
myfun12<-function(f1){
  library(FrF2)
  des<-pb(12,f1)
  return(des)
}


##当因子数12<=f1<20,使用此函数##
myfun20<-function(f1){
  library(FrF2)
  des<-pb(20,f1)
  return(des)
}


##f1<=20&f1<28
myfun28<-function(f1){
  library(FrF2)
  des<-pb(28,f1)
  return(des)
}

###f1<=28&f1<32时
myfun32<-function(f1){
  library(FrF2)
  des<-pb(32,f1)
  return(des)
}




