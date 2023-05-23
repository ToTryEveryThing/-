<template>
    <el-button style="float:right" type="danger" @click="logout">退出</el-button>
    <el-button style="float:right; margin-right:20px" type="primary" @click="add">添加</el-button>
    <el-table :data="table" border  style="width: 100%">
        <el-table-column prop="address" label="演出地址" width="250" />
        <el-table-column prop="numberOfPeople" label="人数" width="250" />
        <el-table-column prop="cost" label="费用" width="250"/>
        <el-table-column prop="title" label="演出标题" width="250"/>
        <el-table-column prop="message" label="演出信息" width="250"/>
        <el-table-column prop="issuer" label="发行商" width="250"/>
        <el-table-column prop="time" label="演出时间" width="250">
            <template #default="scope">
                <el-date-picker
                readonly
                    v-model="scope.row.time"
                    type="datetime"
                    format="YYYY/MM/DD HH:mm:ss"
                    placeholder="Select date and time"
                />
              </template>
            </el-table-column>
        <el-table-column fixed="right" label="Operations" min-width="180">
            <template #default="scope">
              <el-button link type="danger" size="small" @click.prevent="deleteRow(scope.$index)">
                Remove
              </el-button>
              <el-button link type="primary" @click.prevent="editRow(scope.$index)">Edit</el-button>
            </template>
          </el-table-column>
      </el-table>

      <el-drawer v-model="drawer"  :with-header="false">
        <el-form
          :label-position="right"
          label-width="100px"
          :model="tem"
          style="max-width: 460px">
          <el-form-item label="演出地址">
             <el-input v-model="tem.address" />
          </el-form-item>
          <el-form-item label="人数">
            <el-input v-model.number="tem.numberOfPeople" />
         </el-form-item>
         <el-form-item label="费用">
            <el-input v-model="tem.cost" />
         </el-form-item>
         <el-form-item label="演出标题">
            <el-input v-model="tem.title" />
         </el-form-item>
         <el-form-item label="演出信息">
            <el-input v-model="tem.message" />
         </el-form-item>
         <el-form-item label="发行商">
            <el-input v-model="tem.issuer" />
         </el-form-item>
         <el-form-item label="演出时间">
            <el-date-picker
                v-model="tem.time"
                type="datetime"
                format="YYYY/MM/DD HH:mm:ss"
                placeholder="Select date and time"
            />
         </el-form-item>
          <el-button type="primary" @click="save">save</el-button>
        </el-form>
      </el-drawer>
      <el-drawer v-model="DDDDDrawer"  :with-header="false">
        <el-form
          :label-position="right"
          label-width="100px"
          :model="aaa"
          style="max-width: 460px">
          <el-form-item label="演出地址">
             <el-input v-model="aaa.address" />
          </el-form-item>
          <el-form-item label="人数">
            <el-input v-model.number="aaa.numberOfPeople" />
         </el-form-item>
         <el-form-item label="费用">
            <el-input v-model="aaa.cost" />
         </el-form-item>
         <el-form-item label="演出标题">
            <el-input v-model="aaa.title" />
         </el-form-item>
         <el-form-item label="演出信息">
            <el-input v-model="aaa.message" />
         </el-form-item>
         <el-form-item label="发行商">
            <el-input v-model="aaa.issuer" />
         </el-form-item>
         <el-form-item label="演出时间">
            <el-date-picker
                v-model="aaa.time"
                type="datetime"
                format="YYYY/MM/DD HH:mm:ss"
                placeholder="Select date and time"
            />
         </el-form-item>
          <el-button type="primary" @click="addRow">add</el-button>
        </el-form>
      </el-drawer>
</template>

<script>
import $ from 'jquery'
import {ref, onMounted, reactive} from 'vue'; 
import router from '@/router';
// import dayjs from 'dayjs'
export default {

    setup(){
        let aaa = reactive({
            id: null,
            address: '',
            numberOfPeople:null,
            cost:'',
            title: '',
            message:'',
            issur: '',
            time: ''
        })
        let DDDDDrawer = ref(false)
        let drawer = ref(false)
        let table = ref([])
        let tem = ref({})
        const show = ()=>{
            $.ajax({
                url:'http://127.0.0.1:9090/play/select/',
                method:"GET",
                headers:{
                    Authorization:"Bearer " + localStorage.getItem("token")
                },
                success(res){
                    table.value = res.data
                    console.log(res)
                }
            })
        }

        const logout = ()=>{
            router.push("/login")
            localStorage.removeItem("token")
        }

        const deleteRow = (i)=>{
            let id = table.value[i].id;
            console.log(id)
            $.ajax({
                url:"http://127.0.0.1:9090/play/delete/",
                method:"delete",
                headers:{
                    Authorization:"Bearer " + localStorage.getItem("token")
                },
                data:{
                    id
                },
                success(res){
                    if(res.message === "success")
                    show()
                }
            })
        }

        const add = ()=>{
            DDDDDrawer.value = true
        }
        
        const addRow = ()=>{
            $.ajax({
                url:"http://127.0.0.1:9090/play/add/",
                method:"put",
                headers:{
                    Authorization:"Bearer " + localStorage.getItem("token")
                },
                contentType: 'application/json',
                data:JSON.stringify(aaa),
                success(res){
                    if(res.message === "success")alert("更新成功")
                    else alert("仔细检查吧")
                    show()
                },
                error(){
                    alert("仔细检查吧")
                }
                
            })
            DDDDDrawer.value = false
        }

        const editRow = i =>{
            tem.value = table.value[i]
            drawer.value = true
        }

        const save = ()=>{
            $.ajax({
                url:"http://127.0.0.1:9090/play/update/",
                method:"post",
                headers:{
                    Authorization:"Bearer " + localStorage.getItem("token")
                },
                contentType: 'application/json',
                data:JSON.stringify({
                    "id": tem.value.id,
                    "address": tem.value.address,
                    "numberOfPeople":tem.value.numberOfPeople,
                    "cost":tem.value. cost,
                    "title": tem.value.title,
                    "message":tem.value. message,
                    "issuer": tem.value.issuer,
                    "time": tem.value.time
                }),
                success(res){
                    if(res.message === "success")alert("更新成功")
                    else alert("输入有问题")
                    show()
                }
            })
            drawer.value = false
        }

        onMounted(()=>{
            show()
        })

        return {
            logout,deleteRow,editRow,
            drawer,tem,save,add,aaa,
            table,DDDDDrawer,addRow
        }
    }



}
</script>

<style>

</style>