 myfunbd<-function(b,v){
    Resultdata<-data.frame(block=factor(rep(1:b,each=v)),treat=factor(rep(1:v)))
    return(Resultdata)
 }