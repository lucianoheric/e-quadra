<template>
    <div class="input_modaluser" v-show="visivel">
        <h1>Usuário</h1>
        <input class="input_modaluser" type="text" v-model="name" placeholder="nome"/>
        <div style="height:5px;"></div>
        <input class="input_modaluser" type="text" v-model="login" placeholder="login/email"/>
        <div style="height:5px;"></div>
        <input class="input_modaluser" type="text" v-model="passwd" placeholder="senha"/>
        <div style="height:5px;"></div>
        <input class="input_modaluser" type="text" v-model="is_active" placeholder="status"/>
        <div style="height:5px;"></div>
        <input class="input_modaluser" type="text" v-model="id" placeholder="id"/>        
        <div style="height:5px;"></div>
        <input class="input_modaluser" type="text" v-model="ts_created" placeholder="data criação"/>
        <div style="height:5px;"></div>
        <input class="input_modaluser" type="text" v-model="ts_removed" placeholder="data remoção"/>                        
    </div>
</template>

<script>
export default {
    name: 'UserSelected',
    props: {            
        id : {
            type: Number,
            default: null
        },
        name: {
            type: String,
            require: true
        },
        login: {
            type: String,
            require: true,
            default: null
        },
        is_active: {
            type: Boolean,
            require: true,
            default: true
        },
        ts_created: {
            type: String,
            require: true
        },
        ts_removed: {
            type: String,
            require: false            
        },
        passwd: {
            type: String,
            require: true           
        },
        visivel:{
            type: Boolean,
            default: false
        }
    }
    
}
</script>

<style scoped>
.input_modaluser {
  width: 88%;
  visibility: hidden;
}
</style>