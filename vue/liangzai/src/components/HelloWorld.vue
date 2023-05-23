<template>
  <el-row justify="space-evenly">
    <el-col :span="8"><div class="grid-content ep-bg-purple-light" />
        <el-form
          :label-position="right"
          label-width="100px"
          :model="formLabelAlign"
          style="max-width: 460px">
          <el-form-item label="Name">
             <el-input v-model="formLabelAlign.name" />
          </el-form-item>
          <el-form-item label="Password">
              <el-input type="password" v-model="formLabelAlign.password" />
          </el-form-item>
        </el-form>
        <el-button @click="submit" type="primary">登录</el-button>
        <el-button type="info" @click="register" >注册</el-button>
    </el-col>
  </el-row>
</template>

<script>
import { reactive} from 'vue'
import $ from 'jquery'
import router from '@/router'
export default {
    setup(){
      const formLabelAlign = reactive({
        name: '',
        password: '',
      })

      const submit = ()=>{
          $.ajax({
            url:"http://127.0.0.1:9090/user/login/",
            method:"POST",
            data:{
              name: formLabelAlign.name,
              password: formLabelAlign.password
            },
            success(res){
              if(res.message === "success"){
                localStorage.setItem("token",res.token)
                router.push("/")
              }
            }
          })
      }

      const register = ()=>{
        $.ajax({
            url:"http://127.0.0.1:9090/user/register/",
            method:"POST",
            data:{
              name: formLabelAlign.name,
              password: formLabelAlign.password
            },
            success(res){
              console.log(res)
              if(res.message === "success"){
                alert("注册成功")
              }else alert(res.message)
            }
          })
      }

      return {
        formLabelAlign,
        register,
        submit




      }
    }
}
</script>

<style>

</style>