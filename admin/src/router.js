import Vue from 'vue'
import Router from 'vue-router'
import Login from './views/login.vue'
import Admin from './views/admin.vue'

Vue.use(Router)


export default new Router({
    mode:'history',//还有一种hash格式，带有#号
    base:process.env.BASE_URL,
    routes:[{
        path:'*',//无论输入什么，都会跳转到/login地址
        redirect:"/login",
    },{
        path: '/login',
        component:Login
    },{
        path: '/admin',
        component:Admin
    }]
})