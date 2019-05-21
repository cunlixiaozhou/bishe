<template>
    <div class="main_body">
        <div class="main_header">
            <div class="main_header_left">
                <div class="times">
                    <el-form :inline="true" :model="filters" style="margin:18px 0 0 10px;">
                        <el-form-item>
                            <el-date-picker
                                    v-model="startDate"
                                    type="date"
                                    placeholder="开始月份"
                                    value-format="yyyy-MM-dd"
                                    style="width:130px;display: inline-block;margin: 0"
                                    size="small">
                            </el-date-picker>
                        </el-form-item>
                        <el-form-item>
                            <el-date-picker
                                    v-model="endDate"
                                    type="date"
                                    placeholder="结束月份"
                                    value-format="yyyy-MM-dd"
                                    style="width:130px;display: inline-block;margin: 0"
                                    size="small">
                            </el-date-picker>
                        </el-form-item>
                        <el-form-item>
                            <el-button type="primary" size="small" icon="el-icon-search" @click="getHwData">查询</el-button>
                        </el-form-item>
                    </el-form>
                </div>
            </div>
            <div class="main_header_center">
                <h2>货车周转时间完成情况</h2>
            </div>
            <div class="main_header_right">
                <!-- <div class="nav_list">
                    <ul>
                        <li><a href="http://localhost:8080/#/lvke_Finish">旅客发送人</a></li>
                        <li><a href="http://localhost:8080/#/hw_Finish">货物发送吨</a></li>
                        <li><a href="http://localhost:8080/#/hczz_Finish">货车周转时间</a></li>
                    </ul>
                </div> -->
                <a href="http://localhost:8080/#/provinceRank"><div class="go_page"></div></a>
            </div>
        </div>
        <div class="main_top">
            <div class="main_top_center">
                <div class="main_top_center_top">
                    <div id="chart1"></div>
                    <!--<div class="main_top_center_top_1">-->
                    <!--</div>-->
                    <!--<div class="main_top_center_top_2"></div>-->
                    <!--<div class="main_top_center_top_3"></div>-->
                </div>
                <div class="main_top_center_bottom">
                    <div class="main_top_right_title">
                        <div class="title">
                            集团公司
                            <img src="../../assets/title_border.png" alt="">
                        </div>
                    </div>
                    <div id="chart2"></div>
                </div>
            </div>
        </div>
        <div class="main_bottom">
            <div class="main_top_left">
                <div class="main_top_left_title">
                    <div class="title">
                        主要货运站
                        <div class="select_hw">
                            <select class="choice" v-model="couponSelected" v-on:change="indexSelect($event)" style="width: 80px; height: 30px;background: #010e43;color: white">
                                　　　　<option v-for="item in optiondata" :value="item.name">{{item.name}}</option>
                                　　</select>
                        </div>
                        <img src="../../assets/title_border.png" alt="">
                    	</div>
                </div>
                <div class="main_bottom_top">
                	<div id="chart3"></div>
                </div>
                <div class="main_bottom_bottom">
                	<div id="chart4"></div>
                </div>
                
            </div>
            <div class="main_top_right">
                <div class="main_top_right_title">
                    <div class="title">
                        分品类
                        <img src="../../assets/title_border.png" alt="">
                    </div>
                </div>
                <div class="main_bottom_top">
                	<div id="chart5"></div>
                </div>
                <div class="main_bottom_bottom">
                	<div id="chart6"></div>
                </div>
            </div>
        </div>
    </div>
</template>
<script>
    import echarts from 'echarts'
    export default {
        data(){
            return{
                startDate:'2018-11-01',
                endDate:'2018-11-08',
                optiondata: [{
                    "indexId":1,
                    "name": "中时"
                }, {
                    "indexId":2,
                    "name": "停时"
                },  {
                    "indexId":3,
                    "name": "旅速"
                }],
                title_name:'集装箱',
                couponSelected:'',
                title_name:'中时',
                title_name_Four:'中时',
                title_name1_leijiType:'zhongshi',
                title_name1_eachType:'zhongshi',
                BarTuFour_date:[],
            }

        },
        created(){
            //如果没有这句代码，select中初始化会是空白的，默认选中就无法实现
            this.couponSelected = this.optiondata[0].name;
        },
        mounted(){
            //this.drawChart1Bar();
            // this.drawChart2Bar();
            //this.drawChart3Bar();
            //this.drawChart4Bar();
            //this.drawChart5Bar();
            //this.drawChart6Bar();
            this.getHczzData();
//          this.getjzxData();
        },
        methods:{
            getHwData(){
                this.getHczzData();
//              this.getjzxData();
                this.couponSelected = this.optiondata[0].name;
            },
           getHczzData(){
                let para={
                    startNy:this.startDate,
                    endNy:this.endDate,
                    eachType:'zhongshi',
                    leijiType:'zhongshi'
                }
                this.$http.get('/api/d18DataDate/getHcZzSjScreen', {
                    params: para
                }).then(res => {
                     	this.getTuOneData(res);
                   		this.getTuTwoData(res);
                   		this.getTuFourData(res);
                  		this.getTuSixData(res);
                   		this.getTuFiveData(res);
                   		this.getTuThreeData(res);
//                  console.log(res.data)

                }, error => {
                    console.info(error)
                });
            },
            indexSelect(event){
                console.log(event.target.value)
                this.value_name = event.target.value
                if(this.value_name==='中时'){
                    this.title_name=event.target.value;
                    this.title_name1_leijiType ='zhongshi'
                }else if(this.value_name==='停时'){
                    this.title_name=event.target.value
                    this.title_name1_leijiType ='tingshi'
                }else if(this.value_name==='旅速'){
                    this.title_name=event.target.value;
                    this.title_name1_leijiType ='lvsu'
                }
              this.getHczz_GsLjData()
              
            },
            getHczz_GsLjData(){
                let para={
                    startNy:this.startDate,
                    endNy:this.endDate,
                    // eachType:'zhongshi',
                    leijiType:this.title_name1_leijiType
                }
                this.$http.get('/api/d18DataDate/getHcWcQkYLjWcData', {
                    params: para
                }).then(res => {
                    this.getTuFiveData(res);
//                  this.getTuThreeData(res);
//					 this.drawChart4Bar();
                }, error => {
                    console.info(error)
                });
            },
//          getjzxData(){
//              let para={
//                  // qyfw: 1,
//                  startmonth:this.startDate,
//                  endmonth:this.endDate,
//                  choicepl:this.title_name
//                  // pldm:0
//              }
//              this.$http.get('/api/hySendResultMonth/getTuSixData',{
//                  params:para
//              }).then((res)=>{
//                  this.jzxData = res.data;
//                  console.log("-------")
//                  console.log(this.jzxData)
//                  console.log("-------")
////                  this.getTuSixData()
//              }, error => {
//                  console.info(error)
//              })
//          },
            // //集团旅客发送量累计完成情况
            getTuOneData(res){
                // this.thisYearTotalData.push(res.data.jtTableData.thisYearTotal);
                // console.log(res.data.jtTableData[0].thisYearTotal)
                this.sj_finish_data = res.data.tableData.total;
                this.ndjh_bl = res.data.tableData.complete;
                this.tbzzl_data = res.data.tableData.tbzzl;
                console.log("集团"+this.sj_finish_data)
                this.drawChart1Bar();
            },
            // //获取集团公司旅客发送量分月完成情况数据
            getTuTwoData(res){
                let PLData=[];
                this.Bar_hw_date=[];
                this.Bar_hw_this_ny_total=[];
                this.Bar_hw_last_ny_total=[];
                this.Bar_hw_month_plan=[];
                this.Bar_hw_month_plan_bl=[];
                this.Bar_hw_tbzzl=[];
                this.Bar_hw_date=res.data.table2Ny;
                this.Bar_hw_this_ny_total=res.data.table2Total;
//              this.Bar_hw_last_ny_total=this.jtzMonthData.jtmonthqnwc;
//              this.Bar_hw_month_plan = this.jtzMonthData.jtmonthwcjh;
//              this.Bar_hw_month_plan_bl = this.jtzMonthData.jtmonthwcjhbfb;
//              this.Bar_hw_tbzzl = this.jtzMonthData.jtmonthtbzzl
                this.drawChart2Bar();
            },
            // // //获取站段旅客发送量累计完成情况数据
            getTuFourData(res){
                this.Gs_sjxg_finish_data = res.data.jtZsXgfCeTable[0].sjxgf;
                this.Gs_clxg_data = res.data.jtZsXgfCeTable[0].clxgf;
                this.Gs_cz_data = res.data.jtZsXgfCeTable[0].ce;
                this.drawChart5Bar();
            },
            // // //获取站段旅客发送量累计完成情况数据
            getTuSixData(res){
                // let jt_data = jt_jzx_Finish.RECORDS;
               this.BarTuSix_date=[];
                this.BarTuSix_ClxgData=[];
                this.BarTuSix_sjxgData=[];


                this.BarTuSix_date=res.data.zsXgfNyr;
                this.BarTuSix_ClxgData =res.data.zsXgfClxgf;
                this.BarTuSix_sjxgData = res.data.zsXgfSjxgf;
                this. drawChart6Bar();

            },
            // //获取集团公司动车与普速旅客发送量完成比重数据
            getTuFiveData(res){
                this.Gs_sj_finish_data = res.data.jtLjWc[0].total;
                this.Gs_ndjh_bl = res.data.jtLjWc[0].tbzzl;
                this.Gs_tbzzl_data = res.data.jtLjWc[0].complete;
                this.drawChart3Bar()
            },
            //获取主要客运站旅客发送量累计完成情况数据
            getTuThreeData(res){
                this.BarTuFour_date=[];
                this.BarTuFour_this_ny_total=[];
                this.BarTuFour_month_plan_bl=[];
                this.BarTuFour_date=res.data.table4Ny;
                this.BarTuFour_this_ny_total =res.data.table4Total;
                this.drawChart4Bar();
            },
            drawChart2Bar(){
                let myChart= echarts.init(document.getElementById('chart2'));
                var fontColor = '#30eee9';
                myChart.setOption({
                    // backgroundColor:'#11183c',
                    grid: {
                        left: '3%',
                        right: '3%',
                        top:'20%',
                        bottom: '15%',
                        containLabel: true
                    },
                    tooltip : {
                        show: true,
                        trigger: 'item'
                    },
                    legend: {
                        show:true,
                        x:'center',
                        y:'35',
                        icon: 'stack',
                        itemWidth:10,
                        itemHeight:10,
                        textStyle:{
                            color:'#1bb4f6'
                        },
                        data:['实际完成','年计划进度百分比%','同比增长百分比%']
                    },
                    xAxis : [
                        {
                            type : 'category',
                            boundaryGap : false,
                            axisLabel:{
                                color: fontColor
                            },
                            axisLine:{
                                show:true,
                                lineStyle:{
                                    color:'#397cbc'
                                }
                            },
                            axisTick:{
                                show:false,
                            },
                            splitLine:{
                                show:true,
                                lineStyle:{
                                    color:'#195384'
                                }
                            },
                            data : this.Bar_hw_date
                        }
                    ],
                    yAxis : [
                        {
                            type : 'value',
                            name : '单位(万人)',
                            // min:0,
                            // max:1000,
                            axisLabel : {
                                formatter: '{value}',
                                textStyle:{
                                    color:'#2ad1d2'
                                }
                            },
                            axisLine:{
                                lineStyle:{
                                    color:'#27b4c2'
                                }
                            },
                            axisTick:{
                                show:false,
                            },
                            splitLine:{
                                show:true,
                                lineStyle:{
                                    color:'#11366e'
                                }
                            }
                        },
                        {
                            type : 'value',
                            name : '百分比',
                            axisLabel : {
                                formatter: '{value} %',
                                textStyle:{
                                    color:'#186afe'
                                }
                            },
                            axisLine:{
                                lineStyle:{
                                    color:'#186afe'
                                }
                            },
                            axisTick:{
                                show:false,
                            },
                            splitLine:{
                                show:true,
                                lineStyle:{
                                    color:'#11366e'
                                }
                            }
                        }
                    ],
                    series : [
                        {
                            name:'年计划进度百分比%',
                            type:'line',
                            yAxisIndex:1,
                            symbol:'circle',
                            symbolSize: 8,
                            itemStyle: {
                                normal: {
                                    color:'#0092f6',
                                    lineStyle: {
                                        color: "#0092f6",
                                        width:1
                                    },
                                    areaStyle: {
                                        //color: '#94C9EC'
                                        color: new echarts.graphic.LinearGradient(0, 1, 0, 0, [{
                                            offset: 0,
                                            color: 'rgba(7,44,90,0.3)'
                                        }, {
                                            offset: 1,
                                            color: 'rgba(0,146,246,0.9)'
                                        }]),
                                    }
                                }
                            },
                            markPoint:{
                                itemStyle:{
                                    normal:{
                                        color:'red'
                                    }
                                }
                            },
                            data:this.Bar_hw_month_plan_bl
                        },
                        {
                            name:'同比增长百分比%',
                            type:'line',
                            yAxisIndex:1,
                            symbol:'circle',
                            symbolSize: 8,

                            itemStyle: {
                                normal: {
                                    color:'#ffb616',
                                    lineStyle: {
                                        color: "#ffb616",
                                        width:1
                                    },
                                    areaStyle: {
                                        //color: '#94C9EC'
                                        color: new echarts.graphic.LinearGradient(0, 1, 0, 0, [{
                                            offset: 0,
                                            color: 'rgba(255,285,32,0.3)'
                                        }, {
                                            offset: 1,
                                            color: 'rgba(255,285,32,0.9)'
                                        }]),
                                    }
                                }
                            },
                            data:this.Bar_hw_tbzzl
                        },
                        {
                            name:'实际完成',
                            type:'bar',
                            stack: '总量',
                            symbol:'circle',
                            symbolSize: 8,
                            barWidth:10,
                            itemStyle: {
                                normal: {
                                    color: '#aecb56',
                                    lineStyle: {
                                        color: "#aecb56",
                                        width:1
                                    },
                                    areaStyle: {
                                        //color: '#94C9EC'
                                        color: new echarts.graphic.LinearGradient(0, 1, 0, 0, [{
                                            offset: 0,
                                            color: 'rgba(7,44,90,0.3)'
                                        }, {
                                            offset: 1,
                                            color: 'rgba(114,144,89,0.9)'
                                        }]),
                                    }
                                }
                            },
                            data:this.Bar_hw_this_ny_total
                        }
                    ]
                })

            },
            drawChart1Bar(){
                let myChart= echarts.init(document.getElementById('chart1'));
                myChart.setOption({
                    // backgroundColor:'#11183c',
                    title: [{
                        x: "19%",
                        bottom: 60,
                        text: '累计完成',
                        textStyle: {
                            fontWeight: 'normal',
                            fontSize: 20,
                            color: "#fff"
                        },
                    }, {
                        x: "42%",
                        bottom: 60,
                        text: '完成年计划(%)',
                        textStyle: {
                            fontWeight: 'normal',
                            fontSize: 20,
                            color: "#fff"
                        },
                    }, {
                        x: "68%",
                        bottom: 60,
                        text: '同比增长(%)',
                        textStyle: {
                            fontWeight: 'normal',
                            fontSize: 20,
                            color: "#fff"
                        },
                    }],
                    tooltip: {
                        trigger: 'item',
                        formatter: "{b}: {c}",

                    },
                    series: [{
                        type: 'pie',
                        label: { //标签的位置
                            normal: {
                                show: false,
                            }
                        },
                        clockwise: false,
                        radius: ['30%', '40%'],
                        center: ['25%', '40%'],
                        data: [{
                            value: this.sj_finish_data,
                            name: '累计完成',
                            itemStyle: {
                                color: 'rgba(241,192,73,1.0)'
                            }
                        }]
                    }, {
                        name: '',
                        type: 'pie',
                        clockwise: false,
                        silent: true,
                        minAngle: 20, //最小的扇区角度（0 ~ 360）
                        center: ['25%', '40%'], //饼图的中心（圆心）坐标
                        radius: ['0%', '40%'],
                        itemStyle: { //图形样式
                            normal: {
                                color: {
                                    type: 'radial',
                                    x: 0.5,
                                    y: 0.5,
                                    r: 0.5,
                                    colorStops: [{
                                        offset: 0,
                                        color: 'rgba(241,192,73,0.5)' // 0% 处的颜色
                                    }, {
                                        offset: 1,
                                        color: 'rgba(241,192,73,1)' // 100% 处的颜色
                                    }],
                                    globalCoord: false // 缺省为 false
                                },
                                borderWidth: 1.5,
                                opacity: 0.21,
                            }
                        },
                        label: { //标签的位置
                            normal: {
                                show: true,
                                align: 'center',
                                position: 'center', //标签的位置
                                formatter: "{c}",
                                fontSize: 20,
                                textStyle: {
                                    color: 'rgba(241,192,73,1.0)',
                                }
                            }
                        },
                        data: [{
                            value: this.sj_finish_data
                        }]
                    }, {
                        type: 'pie',
                        label: { //标签的位置
                            normal: {
                                show: false,
                            }
                        },
                        clockwise: false,
                        radius: ['30%', '40%'],
                        center: ['50%', '40%'],
                        data: [{
                            value: this.ndjh_bl,
                            name: '完成年计划进度(%)',
                            itemStyle: {
                                color: 'rgba(48,230,142,1.0)'
                            }
                        }]
                    }, {
                        name: '',
                        type: 'pie',
                        clockwise: false,
                        silent: true,
                        minAngle: 20, //最小的扇区角度（0 ~ 360）
                        center: ['50%', '40%'], //饼图的中心（圆心）坐标
                        radius: ['0%', '40%'],
                        itemStyle: { //图形样式
                            normal: {
                                color: {
                                    type: 'radial',
                                    x: 0.5,
                                    y: 0.5,
                                    r: 0.5,
                                    colorStops: [{
                                        offset: 0,
                                        color: 'rgba(48,230,142,0.1)' // 0% 处的颜色
                                    }, {
                                        offset: 1,
                                        color: 'rgba(48,230,142,1)' // 100% 处的颜色
                                    }],
                                    globalCoord: false // 缺省为 false
                                },
                                borderWidth: 1.5,
                                opacity: 0.21,
                            }
                        },
                        label: { //标签的位置
                            normal: {
                                show: true,
                                align: 'center',
                                position: 'center', //标签的位置
                                formatter: "{c}",
                                fontSize: 20,
                                textStyle: {
                                    color: 'rgba(48,230,142,1.0)',
                                }
                            }
                        },
                        data: [{
                            value: this.ndjh_bl
                        }]
                    }, {
                        type: 'pie',
                        label: { //标签的位置
                            normal: {
                                show: false,
                            }
                        },
                        clockwise: false,
                        radius: ['30%', '40%'],
                        center: ['75%', '40%'],
                        data: [{
                            value: this.tbzzl_data,
                            name: '同比增长(%)',
                            itemStyle: {
                                color: 'rgba(232,30,135,1.0)'
                            }
                        }]
                    }, {
                        name: '',
                        type: 'pie',
                        clockwise: false,
                        silent: true,
                        minAngle: 20, //最小的扇区角度（0 ~ 360）
                        center: ['75%', '40%'], //饼图的中心（圆心）坐标
                        radius: ['0%', '40%'],
                        itemStyle: { //图形样式
                            normal: {
                                color: {
                                    type: 'radial',
                                    x: 0.5,
                                    y: 0.5,
                                    r: 0.5,
                                    colorStops: [{
                                        offset: 0,
                                        color: 'rgba(232,30,135,0.1)' // 0% 处的颜色
                                    }, {
                                        offset: 1,
                                        color: 'rgba(232,30,135,1)' // 100% 处的颜色
                                    }],
                                    globalCoord: false // 缺省为 false
                                },
                                borderWidth: 1.5,
                                opacity: 0.21,
                            }
                        },
                        label: { //标签的位置
                            normal: {
                                show: true,
                                align: 'center',
                                position: 'center', //标签的位置
                                formatter: "{c}",
                                fontSize: 20,
                                textStyle: {
                                    color: 'rgba(232,30,135,1.0)',
                                }
                            }
                        },
                        data: [{
                            value: this.tbzzl_data
                        }]
                    }]
                })

            },
            drawChart3Bar(){
               let myChart= echarts.init(document.getElementById('chart3'));
                myChart.setOption({
                    // backgroundColor:'#11183c',
                    title: [{
                        x: "19%",
                        bottom: 0,
                        text: '累计完成',
                        textStyle: {
                            fontWeight: 'normal',
                            fontSize: 20,
                            color: "#fff"
                        },
                    }, {
                        x: "42%",
                        bottom: 0,
                        text: '完成年计划(%)',
                        textStyle: {
                            fontWeight: 'normal',
                            fontSize: 20,
                            color: "#fff"
                        },
                    }, {
                        x: "68%",
                        bottom: 0,
                        text: '同比增长(%)',
                        textStyle: {
                            fontWeight: 'normal',
                            fontSize: 20,
                            color: "#fff"
                        },
                    }],
                    tooltip: {
                        trigger: 'item',
                        formatter: "{b}: {c}",

                    },
                    series: [{
                        type: 'pie',
                        label: { //标签的位置
                            normal: {
                                show: false,
                            }
                        },
                        clockwise: false,
                        radius: ['60%', '70%'],
                        center: ['25%', '40%'],
                        data: [{
                            value: this.sj_finish_data,
                            name: '累计完成',
                            itemStyle: {
                                color: 'rgba(241,192,73,1.0)'
                            }
                        }]
                    }, {
                        name: '',
                        type: 'pie',
                        clockwise: false,
                        silent: true,
                        minAngle: 20, //最小的扇区角度（0 ~ 360）
                        center: ['25%', '40%'], //饼图的中心（圆心）坐标
                        radius: ['0%', '70%'],
                        itemStyle: { //图形样式
                            normal: {
                                color: {
                                    type: 'radial',
                                    x: 0.5,
                                    y: 0.5,
                                    r: 0.5,
                                    colorStops: [{
                                        offset: 0,
                                        color: 'rgba(241,192,73,0.5)' // 0% 处的颜色
                                    }, {
                                        offset: 1,
                                        color: 'rgba(241,192,73,1)' // 100% 处的颜色
                                    }],
                                    globalCoord: false // 缺省为 false
                                },
                                borderWidth: 1.5,
                                opacity: 0.21,
                            }
                        },
                        label: { //标签的位置
                            normal: {
                                show: true,
                                align: 'center',
                                position: 'center', //标签的位置
                                formatter: "{c}",
                                fontSize: 20,
                                textStyle: {
                                    color: 'rgba(241,192,73,1.0)',
                                }
                            }
                        },
                        data: [{
                            value: this.Gs_sj_finish_data
                        }]
                    }, {
                        type: 'pie',
                        label: { //标签的位置
                            normal: {
                                show: false,
                            }
                        },
                        clockwise: false,
                        radius: ['60%', '70%'],
                        center: ['50%', '40%'],
                        data: [{
                            value: this.Gs_ndjh_bl,
                            name: '完成年计划进度(%)',
                            itemStyle: {
                                color: 'rgba(48,230,142,1.0)'
                            }
                        }]
                    }, {
                        name: '',
                        type: 'pie',
                        clockwise: false,
                        silent: true,
                        minAngle: 20, //最小的扇区角度（0 ~ 360）
                        center: ['50%', '40%'], //饼图的中心（圆心）坐标
                        radius: ['0%', '70%'],
                        itemStyle: { //图形样式
                            normal: {
                                color: {
                                    type: 'radial',
                                    x: 0.5,
                                    y: 0.5,
                                    r: 0.5,
                                    colorStops: [{
                                        offset: 0,
                                        color: 'rgba(48,230,142,0.1)' // 0% 处的颜色
                                    }, {
                                        offset: 1,
                                        color: 'rgba(48,230,142,1)' // 100% 处的颜色
                                    }],
                                    globalCoord: false // 缺省为 false
                                },
                                borderWidth: 1.5,
                                opacity: 0.21,
                            }
                        },
                        label: { //标签的位置
                            normal: {
                                show: true,
                                align: 'center',
                                position: 'center', //标签的位置
                                formatter: "{c}",
                                fontSize: 20,
                                textStyle: {
                                    color: 'rgba(48,230,142,1.0)',
                                }
                            }
                        },
                        data: [{
                            value: this.Gs_ndjh_bl
                        }]
                    }, {
                        type: 'pie',
                        label: { //标签的位置
                            normal: {
                                show: false,
                            }
                        },
                        clockwise: false,
                        radius: ['60%', '70%'],
                        center: ['75%', '40%'],
                        data: [{
                            value: this.Gs_tbzzl_data,
                            name: '同比增长(%)',
                            itemStyle: {
                                color: 'rgba(232,30,135,1.0)'
                            }
                        }]
                    }, {
                        name: '',
                        type: 'pie',
                        clockwise: false,
                        silent: true,
                        minAngle: 20, //最小的扇区角度（0 ~ 360）
                        center: ['75%', '40%'], //饼图的中心（圆心）坐标
                        radius: ['0%', '70%'],
                        itemStyle: { //图形样式
                            normal: {
                                color: {
                                    type: 'radial',
                                    x: 0.5,
                                    y: 0.5,
                                    r: 0.5,
                                    colorStops: [{
                                        offset: 0,
                                        color: 'rgba(232,30,135,0.1)' // 0% 处的颜色
                                    }, {
                                        offset: 1,
                                        color: 'rgba(232,30,135,1)' // 100% 处的颜色
                                    }],
                                    globalCoord: false // 缺省为 false
                                },
                                borderWidth: 1.5,
                                opacity: 0.21,
                            }
                        },
                        label: { //标签的位置
                            normal: {
                                show: true,
                                align: 'center',
                                position: 'center', //标签的位置
                                formatter: "{c}",
                                fontSize: 20,
                                textStyle: {
                                    color: 'rgba(232,30,135,1.0)',
                                }
                            }
                        },
                        data: [{
                            value: this.Gs_tbzzl_data
                        }]
                    }]
                })

            },
            drawChart4Bar(){
                let myChart= echarts.init(document.getElementById('chart4'));
                var fontColor = '#30eee9';
                myChart.setOption({
                    // backgroundColor:'#11183c',
                    grid: {
                        left: '3%',
                        right: '3%',
                        top:'20%',
                        bottom: '3%',
                        containLabel: true
                    },
                    tooltip : {
                        show: true,
                        trigger: 'item'
                    },
                    legend: {
                        show:true,
                        x:'center',
                        y:'35',
                        icon: 'stack',
                        itemWidth:10,
                        itemHeight:10,
                        textStyle:{
                            color:'#1bb4f6'
                        },
                        data:['实际完成']
                    },
                    xAxis : [
                        {
                            type : 'category',
                            boundaryGap : false,
                            axisLabel:{
                                color: fontColor,
                                rotate:'40',
                            },
                            axisLine:{
                                show:true,
                                lineStyle:{
                                    color:'#397cbc'
                                }
                            },
                            axisTick:{
                                show:false,
                            },
                            splitLine:{
                                show:true,
                                lineStyle:{
                                    color:'#195384'
                                }
                            },
                            data : this.BarTuFour_date
                        }
                    ],
                    yAxis : [
                        {
                            type : 'value',
                            name : '单位(万人)',
                            // min:0,
                            // max:1000,
                            axisLabel : {
                                formatter: '{value}',
                                textStyle:{
                                    color:'#2ad1d2'
                                }
                            },
                            axisLine:{
                                lineStyle:{
                                    color:'#27b4c2'
                                }
                            },
                            axisTick:{
                                show:false,
                            },
                            splitLine:{
                                show:true,
                                lineStyle:{
                                    color:'#11366e'
                                }
                            }
                        }
                    ],
                    series : [
                        {
                            name:'实际完成',
                            type:'bar',
                            stack: '总量',
                            symbol:'circle',
                            symbolSize: 8,
                            barWidth:20,
                            itemStyle: {
                                normal: {
                                    color: '#aecb56',
                                    lineStyle: {
                                        color: "#aecb56",
                                        width:1
                                    },
                                    areaStyle: {
                                        //color: '#94C9EC'
                                        color: new echarts.graphic.LinearGradient(0, 1, 0, 0, [{
                                            offset: 0,
                                            color: 'rgba(7,44,90,0.3)'
                                        }, {
                                            offset: 1,
                                            color: 'rgba(114,144,89,0.9)'
                                        }]),
                                    }
                                }
                            },
                            data:this.BarTuFour_this_ny_total
                        }
                    ]
                })

            },
            drawChart5Bar(){
                let myChart= echarts.init(document.getElementById('chart5'));
                myChart.setOption({
                    // backgroundColor:'#11183c',
                    title: [{
                        x: "17%",
                        bottom: 0,
                        text: '时间相关法累计完成',
                        textStyle: {
                            fontWeight: 'normal',
                            fontSize: 20,
                            color: "#fff"
                        },
                    }, {
                        x: "40%",
                        bottom: 0,
                        text: '车辆相关法累计完成',
                        textStyle: {
                            fontWeight: 'normal',
                            fontSize: 20,
                            color: "#fff"
                        },
                    }, {
                        x: "72%",
                        bottom: 0,
                        text: '差额',
                        textStyle: {
                            fontWeight: 'normal',
                            fontSize: 20,
                            color: "#fff"
                        },
                    }],
                    tooltip: {
                        trigger: 'item',
                        formatter: "{b}: {c}",

                    },
                    series: [{
                        type: 'pie',
                        label: { //标签的位置
                            normal: {
                                show: false,
                            }
                        },
                        clockwise: false,
                        radius: ['60%', '70%'],
                        center: ['25%', '40%'],
                        data: [{
                            value: this.Gs_sjxg_finish_data,
                            name: '时间相关法累计完成',
                            itemStyle: {
                                color: 'rgba(241,192,73,1.0)'
                            }
                        }]
                    }, {
                        name: '',
                        type: 'pie',
                        clockwise: false,
                        silent: true,
                        minAngle: 20, //最小的扇区角度（0 ~ 360）
                        center: ['25%', '40%'], //饼图的中心（圆心）坐标
                        radius: ['0%', '70%'],
                        itemStyle: { //图形样式
                            normal: {
                                color: {
                                    type: 'radial',
                                    x: 0.5,
                                    y: 0.5,
                                    r: 0.5,
                                    colorStops: [{
                                        offset: 0,
                                        color: 'rgba(241,192,73,0.5)' // 0% 处的颜色
                                    }, {
                                        offset: 1,
                                        color: 'rgba(241,192,73,1)' // 100% 处的颜色
                                    }],
                                    globalCoord: false // 缺省为 false
                                },
                                borderWidth: 1.5,
                                opacity: 0.21,
                            }
                        },
                        label: { //标签的位置
                            normal: {
                                show: true,
                                align: 'center',
                                position: 'center', //标签的位置
                                formatter: "{c}",
                                fontSize: 20,
                                textStyle: {
                                    color: 'rgba(241,192,73,1.0)',
                                }
                            }
                        },
                        data: [{
                            value: this.Gs_sjxg_finish_data
                        }]
                    }, {
                        type: 'pie',
                        label: { //标签的位置
                            normal: {
                                show: false,
                            }
                        },
                        clockwise: false,
                        radius: ['60%', '70%'],
                        center: ['50%', '40%'],
                        data: [{
                            value: this.Gs_clxg_data,
                            name: '车辆相关法累计完成',
                            itemStyle: {
                                color: 'rgba(48,230,142,1.0)'
                            }
                        }]
                    }, {
                        name: '',
                        type: 'pie',
                        clockwise: false,
                        silent: true,
                        minAngle: 20, //最小的扇区角度（0 ~ 360）
                        center: ['50%', '40%'], //饼图的中心（圆心）坐标
                        radius: ['0%', '70%'],
                        itemStyle: { //图形样式
                            normal: {
                                color: {
                                    type: 'radial',
                                    x: 0.5,
                                    y: 0.5,
                                    r: 0.5,
                                    colorStops: [{
                                        offset: 0,
                                        color: 'rgba(48,230,142,0.1)' // 0% 处的颜色
                                    }, {
                                        offset: 1,
                                        color: 'rgba(48,230,142,1)' // 100% 处的颜色
                                    }],
                                    globalCoord: false // 缺省为 false
                                },
                                borderWidth: 1.5,
                                opacity: 0.21,
                            }
                        },
                        label: { //标签的位置
                            normal: {
                                show: true,
                                align: 'center',
                                position: 'center', //标签的位置
                                formatter: "{c}",
                                fontSize: 20,
                                textStyle: {
                                    color: 'rgba(48,230,142,1.0)',
                                }
                            }
                        },
                        data: [{
                            value: this.Gs_clxg_data
                        }]
                    }, {
                        type: 'pie',
                        label: { //标签的位置
                            normal: {
                                show: false,
                            }
                        },
                        clockwise: false,
                        radius: ['60%', '70%'],
                        center: ['75%', '40%'],
                        data: [{
                            value: this.Gs_cz_data,
                            name: '差额',
                            itemStyle: {
                                color: 'rgba(232,30,135,1.0)'
                            }
                        }]
                    }, {
                        name: '',
                        type: 'pie',
                        clockwise: false,
                        silent: true,
                        minAngle: 20, //最小的扇区角度（0 ~ 360）
                        center: ['75%', '40%'], //饼图的中心（圆心）坐标
                        radius: ['0%', '70%'],
                        itemStyle: { //图形样式
                            normal: {
                                color: {
                                    type: 'radial',
                                    x: 0.5,
                                    y: 0.5,
                                    r: 0.5,
                                    colorStops: [{
                                        offset: 0,
                                        color: 'rgba(232,30,135,0.1)' // 0% 处的颜色
                                    }, {
                                        offset: 1,
                                        color: 'rgba(232,30,135,1)' // 100% 处的颜色
                                    }],
                                    globalCoord: false // 缺省为 false
                                },
                                borderWidth: 1.5,
                                opacity: 0.21,
                            }
                        },
                        label: { //标签的位置
                            normal: {
                                show: true,
                                align: 'center',
                                position: 'center', //标签的位置
                                formatter: "{c}",
                                fontSize: 20,
                                textStyle: {
                                    color: 'rgba(232,30,135,1.0)',
                                }
                            }
                        },
                        data: [{
                            value: this.Gs_cz_data
                        }]
                    }]
                })

            },
            drawChart6Bar(){
                let myChart= echarts.init(document.getElementById('chart6'));
                var fontColor = '#30eee9';
                myChart.setOption({
                    // backgroundColor:'#11183c',
                    grid: {
                        left: '3%',
                        right: '3%',
                        top:'20%',
                        bottom: '8%',
                        containLabel: true
                    },
                    tooltip : {
                        show: true,
                        trigger: 'item'
                    },
                    legend: {
                        show:true,
                        x:'center',
                        y:'35',
                        icon: 'stack',
                        itemWidth:10,
                        itemHeight:10,
                        textStyle:{
                            color:'#1bb4f6'
                        },
                        data:['时间相关法完成','车辆相关法完成']
                    },
                    xAxis : [
                        {
                            type : 'category',
                            boundaryGap : false,
                            axisLabel:{
                                color: fontColor,
                                rotate:'40',
                            },
                            axisLine:{
                                show:true,
                                lineStyle:{
                                    color:'#397cbc'
                                }
                            },
                            axisTick:{
                                show:false,
                            },
                            splitLine:{
                                show:true,
                                lineStyle:{
                                    color:'#195384'
                                }
                            },
                            data : this.BarTuSix_date
                        }
                    ],
                    yAxis : [
                        {
                            type : 'value',
                            name : '单位(万人)',
                            // min:0,
                            // max:1000,
                            axisLabel : {
                                formatter: '{value}',
                                textStyle:{
                                    color:'#2ad1d2'
                                }
                            },
                            axisLine:{
                                lineStyle:{
                                    color:'#27b4c2'
                                }
                            },
                            axisTick:{
                                show:false,
                            },
                            splitLine:{
                                show:true,
                                lineStyle:{
                                    color:'#11366e'
                                }
                            }
                        },
                        // {
                        //     type : 'value',
                        //     name : '浏览量',
                        //     min:0,
                        //     max:1000,
                        //     axisLabel : {
                        //         formatter: '{value} 人',
                        //         textStyle:{
                        //             color:'#186afe'
                        //         }
                        //     },
                        //     axisLine:{
                        //         lineStyle:{
                        //             color:'#186afe'
                        //         }
                        //     },
                        //     axisTick:{
                        //         show:false,
                        //     },
                        //     splitLine:{
                        //         show:true,
                        //         lineStyle:{
                        //             color:'#11366e'
                        //         }
                        //     }
                        // }
                    ],
                    series : [
                        {
                            name:'车辆相关法完成',
                            type:'line',
                            barWidth:20,
                            itemStyle: {
                                normal: {
                                    color: 'yellow',
                                    lineStyle: {
                                        color: "yellow",
                                        width:3
                                    },
//                                  areaStyle: {
//                                      //color: '#94C9EC'
//                                      color: new echarts.graphic.LinearGradient(0, 1, 0, 0, [{
//                                          offset: 0,
//                                          color: 'rgba(7,44,90,0.3)'
//                                      }, {
//                                          offset: 1,
//                                          color: 'rgba(114,144,89,0.9)'
//                                      }]),
//                                  }
                                }
                            },
                            data:this.BarTuSix_ClxgData
                        },
                        {
                            name:'时间相关法完成',
                            type:'line',
                            barWidth:20,
                            itemStyle: {
                                normal: {
                                    color: 'red',
                                    lineStyle: {
                                        color: "red",
                                        width:3
                                    },
//                                  areaStyle: {
//                                      //color: '#94C9EC'
//                                      color: new echarts.graphic.LinearGradient(0, 1, 0, 0, [{
//                                          offset: 0,
//                                          color: 'rgba(7,44,90,0.3)'
//                                      }, {
//                                          offset: 1,
//                                          color: 'rgba(114,144,89,0.9)'
//                                      }]),
//                                  }
                                }
                            },
                            data:this.BarTuSix_sjxgData 
                        }
                    ]
                })

            },
        }
    }
</script>
<style scoped>
    a{
        text-decoration: none;
    }
     .select_hw{
        /*position: relative;*/
        /*left: 35%;*/
        /*top: 0px;*/
        display: inline-block;
    }
    .title{
        font-size: 20px;
        color: #e9ad5a;
        margin: 10px 0 0 20px;
        box-sizing: border-box;
    }
    .title img{
        position: absolute;
        top: 5px;
    }
    .main_body{
        width: 100%;
        height: 100%;
        position: fixed;
        left: 0;
        top: 0;
        background: url('../../assets/main_bodybg.png') center no-repeat;
        background-size: cover;
        display: flex;
        flex-wrap:wrap;
        /*overflow: scroll;*/
    }
    .main_header{
        width: 100%;
        height: 70px;
        /*border: 1px solid white;*/
        /*box-shadow:-3px 0px 12px #AFEEEE inset,3px 0px 12px #AFEEEE inset;*/
        display: flex;
        justify-content: space-around;
    }
    .main_header_left{
        width:35%;
        height: 70px;
        line-height: 70px;
        position: relative;
        /*border: 1px solid white;*/
        /*box-shadow:-3px 0px 12px #AFEEEE inset,3px 0px 12px #219ff0 inset;*/
    }
    .main_header_center{
        width:30%;
        height: 70px;
        /*border: 1px solid white;*/
        text-align: center;
        line-height: 70px;
        background: url('../../assets/header_border.png') center no-repeat;
        background-size: 100% 100%;
        /*box-shadow:-3px 0px 12px #AFEEEE inset,3px 0px 12px #AFEEEE inset;*/
    }
    .main_header_center h2{
        color: white;
        font-size: 30px;
        margin: 0;

    }
    .main_header_right{
        width:35%;
        height: 70px;
        position: relative;
        /*border: 1px solid white;*/
        /*box-shadow:-3px 0px 12px #AFEEEE inset,3px 0px 12px #AFEEEE inset;*/
    }
    .nav_list{
        position: absolute;
        right: 80px;
    }
    .main_header_right .nav_list ul>li{
        list-style: none;
        float: left;
        width: 84px;
        height: 50px;
        text-align: center;
        color: white;
        line-height: 50px;
        margin-left: 10px;
        background: url("../../assets/bg_border.png") no-repeat;
        background-size:84px 50px;
    }
    .main_header_right .nav_list ul>li>a{
        color: white;
        font-size: 12px;
    }
    .go_page{
        width: 55px;
        height: 55px;
        /*line-height: 28px;*/
        /*text-align: center;*/
        position: absolute;
        right: 8px;
        top: 8px;
        cursor: pointer;
        background-image: url("../../assets/home_logo.png");
        background-size: 55px 55px;

    }
    .main_top{
        width: 100%;
        height: 40%;
        /*border: 1px solid red;*/
        display: flex;
        justify-content: space-around;
    }
    .main_top_left_title,.main_top_right_title{
        width: 100%;
        height:12%;
        position: relative;
    }
    .select_hw{
        /*position: relative;*/
        /*left: 35%;*/
        /*top: 0px;*/
        display: inline-block;
    }
    #chart1{
        height: 86%;
    }
    #chart2{
        height: 86%;
    }
     #chart3{
        height: 86%;
    }
    #chart4{
        height: 86%;
    }
    #chart5{
        height: 86%;
    }
    #chart6{
        height: 86%;
    }
    .main_top_left,.main_top_right{
        width: 49%;
        height:100%;
        background: url('../../assets/main_border.png') center no-repeat;
        background-size: 100% 100%;
    }
    .main_top_center{
        width: 100%;
        height:100%;
        display: flex;
        justify-content: space-around;
        background: url('../../assets/main_border.png') center no-repeat;
        background-size: 100% 100%;
    }
    .main_top_center_top{
        width: 40%;
        height: 100%;
        /*display: flex;*/
        /*justify-content: space-around;*/
    }
    /*#chart1{
        width: 100%;
        height: 100%;
    }*/
    .main_top_center_bottom{
        width: 60%;
        margin-top: 15px;
        box-sizing: border-box;
        height: 100%;
    }

    .main_bottom{
        margin-top: 10px;
        width: 100%;
        height: 50%;
        /*border: 1px solid red;*/
        display: flex;
        justify-content: space-around;
    }
    .main_bottom_top{
        width: 100%;
        height: 30%;
        /*border: 1px solid white;
        box-shadow:-3px 0px 12px #AFEEEE inset,3px 0px 12px #AFEEEE inset;*/
    }
    .main_bottom_bottom{
        width: 100%;
        height: 50%;
        /*border: 1px solid white;
        box-shadow:-3px 0px 12px #AFEEEE inset,3px 0px 12px #AFEEEE inset;*/
    }
</style>