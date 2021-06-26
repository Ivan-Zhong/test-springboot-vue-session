<template>
    <div>
        <h1>logout</h1>
        <button @click="getUsername">find out which user has logged in</button>
        <h2>{{username}}</h2>
        <button @click="logout">logout</button>
    </div>
</template>

<script>
import axios from "axios"
    export default {
        name:"logout",
        data(){
            return {
                username: ""
            }
        },
        methods:{
            getUsername(){
                axios.get("/api/username")
                .then((response) => {
                    this.username = response.data;
                })
            },
            logout(){
                axios.get("/api/logout")
                this.$router.push("login")
            }
        }

    }
</script>

<style lang="scss" scoped>

</style>