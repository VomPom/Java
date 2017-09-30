#####设计
#自变量共三个 ： m0：零水平重复试验次数   p：因子个数    x：各因子取值range
myfun <- function(m0,p,x){
  library(rsm)
  shuju<-list()
  x<-matrix(x,length(x)/2,2,byrow = TRUE)
  for(i in 1:nrow(x)){
    shuju<-c(shuju,list(x[i,]))
  }
  shu_ma <- function(shuju){
      bianma <- function(x){
        return(list(sum(range(x))/2,diff(range(x))/2))
      }
      chuli <- unlist(sapply(shuju,bianma))
      return(chuli)
    }
    chuli <- shu_ma(shuju)
    code<-list()
    for(j in 1:p){
      a=paste("x",j,sep="")
      b=LETTERS[j]
      c=chuli[2*j-1]
      d=chuli[2*j]
      assign(paste("a",j,sep = ""),as.formula(sprintf("%s~(%s-%.1f)/%.1f",a,b,c,d)))
      code<-c(code,list(get(paste("a",j,sep=""))))
    }
    ccd.up <- rsm::cube(p,n0=m0,randomize = F,coding = code)
    return(ccd.up)
  #return("sdf")
}