<template>
	<setcion>
		<div class="main">
			<dl>
				<dt>账号名称</dt>
				<dd>{{message}}<button @click="dialogFormVisible = true">修改</button></dd>
			</dl>
			<el-dialog title="注册信息" :visible.sync="dialogFormVisible">
			  <el-form>
			    <el-form-item label="用户名">
			      <el-input v-model="message" autocomplete="off"></el-input>
			    </el-form-item>
			    <el-fprm-item>
			    	 <el-button @click="dialogFormVisible = false">取 消</el-button>
			    	<el-button type="primary" @click="sign_Sumbit">确 定</el-button>
			    </el-fprm-item>
			  </el-form>
			  <!--<div slot="footer" class="dialog-footer">
			   
			  </div>-->
		</el-dialog>
		</div>
		
	</setcion>
</template>

<script>
	import bus from '../../js/bus'
	export default{
		name:'QuestionShow',
		data(){
			return{
				message:'',
				dialogFormVisible:false,
				checkquestion:''
			}
		},
		mounted(){
			this.message = this.$route.query.title
			
		},
		methods:{
			sign_Sumbit(){
				this.message = this.message;
				this.dialogFormVisible = false
			}
		}
	}
</script>

<style scoped="scoped">
	.main{
		width: 50%;
		height: 100%;
		margin: 10px auto 0px;
	}
</style>