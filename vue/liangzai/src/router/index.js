import { createRouter, createWebHistory } from 'vue-router'
import login from '@/components/HelloWorld'
import main from '@/components/MainView'
const routes = [ 
  {
    path: '/login',
    name: "login",
    component: login,
    meta:{
        is:false
    }
  },
  {
    path: '/',
    name: "main",
    component: main,
    meta:{
        is:true
    }
  }
  
]

const router = createRouter({
  history: createWebHistory(),
  routes
})


router.beforeEach((to,from,next)=>{
   if(to.meta.is === true){
        if(localStorage.getItem("token") === null)next("/login")
        else next()
   }else {
        next()
   }
})
export default router
