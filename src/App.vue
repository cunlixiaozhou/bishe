<template>
	<div id="app">
		<transition name="fade"
		            mode="out-in">
			<router-view></router-view>
		</transition>
	</div>
</template>

<script>
export default {
	name: 'app',
	components: {
	},
	mounted(){
//      if (!!window.ActiveXObject || 'ActiveXObject' in window) {
//          window.addEventListener('hashchange', () => {
//              let currentPath = window.location.hash.slice(1)
//              if (this.$route.path !== currentPath) {
//                  this.$router.push(currentPath)
//              }
//          }, false)
//      }
    },
}

</script>

<style>
body {
	margin: 0px;
	padding: 0px;
	/*新增背景色    改动时间：11/29  关联Home.vue body的背景样式*/
	background-color: rgba(248,248,248,0.5);
	/*background: url(assets/bg1.jpg) center !important;
		background-size: cover;*/
	/*background: #1F2D3D;*/
	/*background: url(assets/background.jpg);*/
	background-size: cover;
	font-family: Helvetica Neue, Helvetica, PingFang SC, Hiragino Sans GB, Microsoft YaHei, SimSun, sans-serif;
	font-size: 14px;
	-webkit-font-smoothing: antialiased;
}

#app {
	position: absolute;
	top: 0px;
	bottom: 0px;
	width: 100%;
}

.el-submenu [class^=fa] {
	vertical-align: baseline;
	margin-right: 10px;
}

.el-menu-item [class^=fa] {
	vertical-align: baseline;
	margin-right: 10px;
}

.toolbar {
	background: #f2f2f2;
	padding: 10px;
	//border:1px solid #dfe6ec;
	margin: 10px 0px;
	.el-form-item {
		margin-bottom: 10px;
	}
}

.fade-enter-active,
.fade-leave-active {
	transition: all .2s ease;
}

.fade-enter,
.fade-leave-active {
	opacity: 0;
}

body .el-table th.gutter{
    display: table-cell!important;
}
 
body .el-table colgroup.gutter{
    display: table-cell!important;
}
body .el-table thead {
    color: #3f3232;
}
body .el-table__body .cell, .el-table__body th div {
	padding-right: 15px;
}
body .el-table .el-button {
	padding: 0px 0px;
}
div.el-transfer{height:530px;}
div.el-transfer-panel{height:517px;}
div.el-transfer-panel__body{height:470px;}
div.el-checkbox-group.el-transfer-panel__list{height:400px;}
span.d1{
	border-top:50px threedlightshadow solid;
	border-left:100px windowframe solid;
	width:0;
	height:0;
	position:relative;
	display:block;
	border-left-color:#fff;
	border-top-color:#f5f7fa/*#f7f7f7*//*#fcfafa*/;
}
/*span{display:block;width:40px}*/
span.s1{
	position:absolute;
	top:-47px;
	left:-45px;
	display:block;
	width:25px;
}

span.s2{
	position:absolute;
	bottom:4px;
	right:55px;
	display:block;
	width:25px;
}

</style>