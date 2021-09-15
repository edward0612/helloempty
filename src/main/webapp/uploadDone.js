
$(function(){
	$.ajax({
	    type: "GET",
	    url: "http://127.0.0.1:8080/uploadDone/loadData",
	    success: function (response) {
	    	console.log(response);
	    	response.forEach(function(value,index,array){
	    		$("select").append(`<option class="options" value="${value.uuid}">${value.filename}</option>`);
	    	});
	    },
	    error: function (thrownError) {
	      console.log(thrownError);
	    }
	 });
	
	
	$("#query").on("click",function(){
		let uuid = $("select").val();
		console.log(uuid)
		let table_el = document.createElement("table");
		let tr_el = document.createElement("tr");
		
		$.ajax({
		    type: "GET",
		    url: "http://127.0.0.1:8080/upload/queryData?uuid=" + uuid,
		    success: function (response) {
		    	console.log(response);
		    	$("div").html('');
		    	$(tr_el).html(`
		    			<th>員工編號</th>
		    			<th>員工姓名</th>
		    			<th>員工信箱</th>
		    			<th>員工手機</th>
		    			<th>員工性別</th>
		    			<th>員工組別</th>`
		    	);
		    	$(table_el).append(tr_el);
		    	response.forEach(function(value,index,array){
		    		let trr_el = document.createElement("tr");
		    		let td_html = `
		    			<th>${value[1]}</th>
		    			<th>${value[2]}</th>
		    			<th>${value[3]}</th>
		    			<th>${value[4]}</th>
		    			<th>${value[5]}</th>
		    			<th>${value[6]}</th>`
		    		;
		    		$(trr_el).append(td_html);
		    		$(table_el).append(trr_el);
		    	})

		    	$("div").append(table_el);
		    },
		    error: function (thrownError) {
		      console.log(thrownError);
		    }
		 });
	});
})
