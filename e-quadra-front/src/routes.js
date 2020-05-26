import User from './components/domains/user/User.vue';
import Home from './components/home/Home.vue';
import modaluser from './components/domains/user/Modal-user.vue';

export const routes = [
    /** path:'' é o mesmo que localhost:3000/#/ */
    {path:'', component:  Home, titulo: 'Home'},
    {path:'/user', component: User, titulo:'Usuário'},
    {path:'/modaluser', component: modaluser, titulo:'modal-user'}
];