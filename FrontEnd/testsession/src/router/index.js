import { createRouter, createWebHistory } from 'vue-router'
import login from '../views/login.vue'
import logout from '../views/logout.vue'

const routes = [
  {
    path: '/login',
    name: 'login',
    component: login
  },
  {
    path: '/logout',
    name: 'logout',
    component: logout
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
