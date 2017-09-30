##二次回归分析

myfun <- function(m0,p){
  library(rsm)
  ccd.up <- rsm::ccd(p,n0=c(0,m0),alpha ="orthogonal",randomize = F)[,-(p+3)]
  return(ccd.up)
}
a<-myfun(0,3)

