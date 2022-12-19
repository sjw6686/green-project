$(function(){

    $.ajax({
        type:"get",
        url:"/user/list",
        success:function(r) {
            for(let i=0; i<r.data.length; i++){
                let tag = 
                '<tr>' +
                    '<td>'+r.data[i].userid+'</td>'+
                    '<td>'+r.data[i].passwd+'</td>'+
                    '<td>'+r.data[i].username+'</td>'+
                    '<td>'+r.data[i].indate+'</td>'+
                    '<td>'+r.data[i].verify+'</td>'+
                    '<td>'+
                        'button data-seq="'+r.data[i].userid+'" class="user_delete">삭제</button>'+
                        '</td>'+
                '</tr>'
                $("user_list_body").append(tag);
            }
        }
    })
})