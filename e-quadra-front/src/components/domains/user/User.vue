<template>
    <div>
        <h1 @click="show('hello-world')" style="display: inline; float: left">Usuário</h1>
        <img src="http://localhost:8081/images/newuser_img.png" class="img_newuser" @click="newUser()" alt="Novo usuário"/>
        <div>
          <form id="form_user" @submit="addUser">
            <input id="input_900" 
                  type="text" 
                  name="editName" 
                  v-model="objUser.name"
                  class="input_reistration image_name" 
                  placeholder="nome"/>
            <div style="height: 5px"></div>
            <input id="input_901" 
                  type="text" 
                  name="editemail" 
                  v-model="objUser.login"
                  class="input_reistration image_email"  
                  placeholder="email"/> 
            <div style="height: 5px"></div>
            <input id="input_902" 
                  type="password" 
                  name="editpasswd" 
                  v-model="objUser.passwd"
                  class="input_reistration image_passwd"  
                  placeholder="senha"/> 
            <button>Incluir</button>
          </form>          
        </div>
        <ol>                 
            <li @click="getdata(user)" v-for="user in users" :key="user.id">
                {{ user.name }}
            </li>
        </ol>   

        <modal name="hello-world">
          hello, world!
        </modal>

    </div>


</template>

<script>
export default {

  mounted(){

    this.getUsers();
  
  },

  data(){

    return {
        users:[],

        objUser: {
          id : null,
          name: '',
          login: '',
          is_active: true,
          ts_created: null,
          ts_removed: null,
          passwd: null
        }

    }

  },

  methods:{

    getUsers(){
      this.cleandata();
      this.$http.get('http://localhost:8080/api/user{/id}')
      .then(res => res.json())
      .then(usu => this.users = usu, err => console.log(err));    
    },

    addUser(){
      //var curdate = new Date;
      this.objUser.ts_created = (new Date).getDate();
      this.objUser.is_active = true;
      this.objUser.name = this.objUser.name.toUpperCase();
      this.$http.post('http://localhost:8080/api/user', this.objUser)
      .then(this.getUsers(), err => console.log(err));    
    },

    cleandata(){
      this.objUser.id         = null;
      this.objUser.name       = '';
      this.objUser.email      = '';
      this.objUser.is_active  = true;
      this.objUser.ts_created = null;
      this.objUser.ts_removed = null;
      this.objUser.passwd     = null;
    },

    getdata(user){
      this.objUser = user;
    },

    newUser(){
      this.cleandata();
      var atrFocus = document.getElementById('input_900');
      atrFocus.focus();
    },

    show() {
      this.$modal.show('dialog', {
        title: 'Alert!',
        text: 'You are too awesome',
        buttons: [
          {
            title: 'Deal with it',
            handler: () => { alert('Woot!') }
          },
          {
            title: '',       // Button title
            default: true,    // Will be triggered by default if 'Enter' pressed.
            handler: () => {} // Button click handler
          },
          {
            title: 'Close'
          }
        ]
      })
    },

    hide(modalname) {
      this.$modal.hide(modalname);
    }
    
  }

}
</script>

<style scoped>

.input_reistration {
  padding-left: 40px;
  color: darkgrey;
  border-radius: 10px;  
  border-width: 2px;
  border-color: rgb(238, 239, 240);
  border-style: solid;
  padding: 10px;  
  padding-left: 36px;
  height: 15px;
  font-size: large;
  width: 88%;
  outline: none;  
  color: darkgrey;
}

textarea:focus, input:focus, select:focus{  
  box-shadow: 0 0 0 0;
  border: 0 none;
  outline: 0;

  border-radius: 10px;  
  border-width: 2px;
  border-color: rgb(163, 233, 250);
  background-color: rgb(240, 248, 252);
  border-style: solid;
  padding: 10px;  
  padding-left: 40px;
  height: 15px;
  font-size: large;
  width: 88%;
  outline: none;  
  color: darkgrey;
}

.image_email{
  background-image:url('http://localhost:8081/images/arroba_img.png');
  background-repeat: no-repeat;
  background-position: 0vh;
  background-size: 32px;
}

.image_name{
  background-image:url('http://localhost:8081/images/person_img.png');
  background-repeat: no-repeat;
  background-position: 0vh;
  background-size: 32px;
}

.image_passwd{
  background-image:url('http://localhost:8081/images/key_img.png');
  background-repeat: no-repeat;
  background-position: 0vh;
  background-size: 32px;
}

.img_newuser{
  width: 32px;
  height: 32px;
  cursor: pointer;
}

</style>