$(function(){

    $("#add_button").click(function(){

        let name = $("#cate_name").val();

        if(name == '' || name == null || name == indefined) {
            alert("카테고리 명을 입력하세요.");
            return;
        }
    })

    $.ajax({
        type:"get",
        url:"/admin/index/category/add?name="+name,
        success:function(data){
            alert(data.message);
        },
        error:function(data){
            console.log(data);
        }
    })

    $.ajax({
        type:"get",
        url:"/admin/index/category/list",
        success:function(r) {
            for(let i=0; i<r.data.length; i++){
                let tag =
            '<tr>' +
                '<td>'+r.data[i].category_idx+'</td>'+
                '<td>'+r.data[i].category_name+'</td>'+
                '<td>'+
                    'button data-seq="'+r.data[i].category_idx+'" class="cate_delete">삭제</button>'+
                    '</td>'+
            '</tr>'
            $("#cate_table_body").append(tag);
    
            }
        }
    })
})

