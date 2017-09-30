myfunzj<-function(jiao,v,f1){
  ####install.packages("DoE.base")
  ####上面那句下载安装包运行一次即可，下面加载安装包的需要每次都运行一遍####
  library(DoE.base)
  if(jiao==3){
    jiao=2
  }
  F=0
  if(v==2){
    F<-f1+jiao
    if(F<=3){
      des<-DoE.base::oa.design(nfactors = f1,nlevels=2,replications = 1,randomize = F)
    }else if(F>3&F<=7){
      if(jiao==0){
        des<-DoE.base::oa.design(L8.2.7)[,c(1:f1)]
      }else if(jiao==1){
        biao<-DoE.base::oa.design(L8.2.7)[,-3]
        des<-biao[,c(1:f1)]
      }else{
        biao<-DoE.base::oa.design(L8.2.7)[,c(1,2,4,7)]
        des<-biao[,c(1:f1)]
      }
    }else if(F>7&F<=11){
      if(jiao==0){
        des<-DoE.base::oa.design(L12.2.11)[,c(1:f1)]
      }else if(jiao==1){
        biao<-DoE.base::oa.design(L12.2.11)[,-3]
        des<-biao[,c(1:f1)]
      }else{
        biao<-DoE.base::oa.design(L12.2.11)[,c(1,2,4,8,9,10)]
        des<-biao[,c(1:f1)]
      }
    }else if(F>11&F<=15){
      if(jiao==0){
        des<-DoE.base::oa.design(L16.2.15)[,c(1:f1)]
      }else if(jiao==1){
        biao<-DoE.base::oa.design(L16.2.15)[,-3]
        des<-biao[,c(1:f1)]
      }else{
        biao<-DoE.base::oa.design(L16.2.15)[,c(1,2,4,8,9,10,11,13,14,15)]
        des<-biao[,c(1:f1)]
      }
    }
  }else if(v==3){
    F<-f1+jiao*2
    if(F<=4){
      des<-DoE.base::oa.design(L9.3.4)[,c(1:f1)]
    }else if(F>4&F<7){
      if(jiao==0){
        des<-DoE.base::oa.design(L18.3.6.6.1)[,c(1:f1)]
      }else if(jiao==1){
        biao<-DoE.base::oa.design(L18.3.6.6.1)[,-c(3,4)]
        des<-biao[,c(1:f1)]
      }else{
        biao<-DoE.base::oa.design(L18.3.6.6.1)[,c(1,2,5)]
        des<-biao[,c(1:f1)]
      }
    }else if(F>=7&F<=13){
      if(jiao==0){
        des<-DoE.base::oa.design(L27.3.13)[,c(1:f1)]
      }else if(jiao==1){
        biao<-DoE.base::oa.design(L27.3.13)[,-c(3,4)]
        des<-biao[,c(1:f1)]
      }else{
        biao<-DoE.base::oa.design(L27.3.13)[,c(1,2,5,9,10,11,12,13)]
        des<-biao[,c(1:f1)]
      }
    }
  }else if(v==4){
    if(f1<=5){
      des<-DoE.base::oa.design(L16.4.5)[,c(1:f1)]
    }else if(f1>5&f1<=9){
      des<-DoE.base::oa.design(L32.4.9)[,c(1:f1)]
    }
  }else if(v==5){
    if(f1<=6){
      des<-DoE.base::oa.design(L25.5.6)[,c(1:f1)]
    }
  }
  return(des)
}
myfunzj1<-function(jiao,v,f1){
  ####上面那句下载安装包运行一次即可，下面加载安装包的需要每次都运行一遍####
  library(DoE.base)
  if(jiao==3){
    jiao=2
  }
  F=0
  if(v==2){
    F<-f1+jiao
    if(F<7){
      if(jiao==0){
        des<-DoE.base::oa.design(L8.2.7)[,c(1:f1)]
      }else if(jiao==1){
        biao<-DoE.base::oa.design(L8.2.7)[,-3]
        des<-biao[,c(1:f1)]
      }else{
        biao<-DoE.base::oa.design(L8.2.7)[,c(1,2,4,7)]
        des<-biao[,c(1:f1)]
      }
    }else if(F>=7&F<15){
      if(jiao==0){
        des<-DoE.base::oa.design(L16.2.15)[,c(1:f1)]
      }else if(jiao==1){
        biao<-DoE.base::oa.design(L16.2.15)[,-3]
        des<-biao[,c(1:f1)]
      }else{
        biao<-DoE.base::oa.design(L16.2.15)[,c(1,2,4,8,9,10,11,13,14,15)]
        des<-biao[,c(1:f1)]
      }
    }
  }else if(v==3){
    F<-f1+jiao*2
    if(F<4){
      des<-DoE.base::oa.design(L9.3.4)[,c(1:f1)]
    }else if(F>=4&F<13){
      if(jiao==0){
        des<-DoE.base::oa.design(L27.3.13)[,c(1:f1)]
      }else if(jiao==1){
        biao<-DoE.base::oa.design(L27.3.13)[,-c(3,4)]
        des<-biao[,c(1:f1)]
      }else{
        biao<-DoE.base::oa.design(L27.3.13)[,c(1,2,5,9,10,11,12,13)]
        des<-biao[,c(1:f1)]
      }
    }
  }else if(v==4){
    if(f1<=5){
      des<-DoE.base::oa.design(L16.4.5)[,c(1:f1)]
    }else if(f1>5&f1<=9){
      des<-DoE.base::oa.design(L32.4.9)[,c(1:f1)]
    }
  }else if(v==5){
    if(f1<=6){
      des<-DoE.base::oa.design(L25.5.6)[,c(1:f1)]
    }
  }
  return(des)
}






