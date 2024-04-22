console.log("Reply Module..........")

var replyService = (function(){

	function add(reply, callback){
		console.log("reply............")

		//비동기 통신
		$.ajax({
			type: "post",
			url: "/reply/new",
			data: JSON.stringify(reply),
			contentType: "application/json; charset=utf-8",
			
			success : function(result, status, xhr){
				if(callback){
					callback(result)
				}
			},
			error: function(xhr, status, er){
				if(error){
					error(er)
				}
			}
		})
		
	}; //end add
	
	
	function getList(param, callback, error) {
		var bno = param.bno;		
		var page = param.page || 1
		
		$.ajax({
			type: "get",
			url: "/reply/pages" + bno + "/" + page,
			
			success: function(list, status, xhr){
				if(callback){
					callback(list)
				}
			}, 
			error: function(xhr, status, err){
				if(error){
					error();
				}
			}
		})
	}
	

	return{
		add: add,
		getList: getList,
	}
})();