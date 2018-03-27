/**
 * Created by zhangxiaotian on 18/2/14.
 */

$('#subLogin').on('click',function () {

  $.ajax({
      url:'/user/submitlogin',
      dataType:'json',
      data:{
          username:$('input[name="username"]').val(),
          password:$('input[name="password"]').val()
      },
      type:'post',
      success:function(data){
          console.log(data);
      },
      error:function (err) {
          console.log(err);
      }
  })
})