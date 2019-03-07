  //this variable is a global jQuery var instead of using "$" all the time. Very handy
  var jq = jQuery.noConflict();
  var BLOCKUI_OVERLAY_MESSAGE_DEFAULT = "Please wait...";

  function setBlockUI(element){
	   jq.blockUI({ css: { fontSize: '22px' }, message: BLOCKUI_OVERLAY_MESSAGE_DEFAULT});
  }
  

  jq(function() {
	  jq("#trorFlyfraktTradevisionForm").submit(function() {
          jq.blockUI({ css: { fontSize: '22px' }, message: BLOCKUI_OVERLAY_MESSAGE_DEFAULT});
	  });
	  
  });
  
  jq(function() {
	  //-------------------
	  //Datatables jquery
	  //-------------------
	  
	  jq(document).ready(function() {
	    //init table (no ajax, no columns since the payload is already there by means of HTML produced on the back-end)
	    jq('#tblF03').dataTable( {
            "tabIndex": -1,  
            "dom": '<"top">t<"bottom"><"clear">',
			  "scrollY":  "200px",
			  //"order": [ [ 1, "asc" ] ],
			  "scrollCollapse":  true
			  //"lengthMenu": [ 25, 50]
		  });
	    
	  });
	  
  });
	  
	  