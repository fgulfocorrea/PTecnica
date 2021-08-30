import Vue from 'vue/dist/vue.js';
import Router from 'vue-router'
import Principal from '@/components/Principal'
import Encuesta from '@/components/Encuesta'
import Resultado from '@/components/Resultado'
import vSelect from "vue-select";
import PrimeVue from 'primevue/config';
import ToastService from 'primevue/toastservice';
/* eslint-disable */
Vue.use(Router)
Vue.component("v-select", vSelect);
Vue.use(PrimeVue);
Vue.use(ToastService);

const router = new Router({  
  routes: [ 
    {
        path: '*',
        redirect: '/principal'
    },
    {
        path: '/',
        redirect: '/principal'
    },
    {
        path: '/principal', 
        name: 'Principal',
        component: Principal
    },
    {
        path: '/encuesta/:id', 
        name: 'Encuesta',
        props: true,
        component: Encuesta

    },
    {
      path: '/resultado/:id', 
      name: 'Resultado',
      props: true,
      component: Resultado

  },
    // {
    //     path: '/:nombre',
    //     name: 'Alcancia',
    //     component: Alcancia
    // },
    // {      
    //     path: '/proyectos',
    //     name: 'Proyectos',
    //     component: Proyectos
    // },
    // {      
    //     path: '/proyectosEnDesarrollo',
    //     name: 'ProyectosEnDesarrollo',
    //     component: ProyectosEnDesarrollo
    // },
    // {
    //     path: '/contacto',
    //     name: 'Contacto',
    //     component: Contacto
    // },
    // {      
    //     path: '/administracion',
    //     name: 'Administracion',
    //     component: Administracion
    // },
    // {      
    //     path: '/crudAdministracion',
    //     name: 'CrudAdministracion',
    //     component: CrudAdministracion
    // },
  ]
})

router.beforeEach((to, from, next) => {
  console.log(to.path);
  next();
/*
  if (to.path == '/principal' && !autorizacion && !usuario) {
    next('home');
  } else if (to.path == '/administracion' && autorizacion && usuario){
    console.log('inAdm');
    next();
  }else if (to.path == '/login' && !autorizacion && !usuario){
    console.log('inLog');
    next();
  } else{
    next();
  }*/
})

export default router;