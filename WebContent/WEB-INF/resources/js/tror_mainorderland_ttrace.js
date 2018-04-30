	//this variable is a global jQuery var instead of using "$" all the time. Very handy
  	var jq = jQuery.noConflict();
  	var BLOCKUI_OVERLAY_MESSAGE_DEFAULT = "Please wait...";
    
  	function setBlockUI(element){
		  jq.blockUI({ css: { fontSize: '22px' }, message: BLOCKUI_OVERLAY_MESSAGE_DEFAULT});
	  }
  	
  	jq(function() {
		jq("#todoEtd").datepicker({ 
			dateFormat: 'yymmdd'  
		});
		jq("#todoAtd").datepicker({ 
			dateFormat: 'yymmdd'  
		});
		jq("#todoEta").datepicker({ 
			dateFormat: 'yymmdd'  
		});
		jq("#todoAta").datepicker({ 
			dateFormat: 'yymmdd'  
		});
    });
  	
  