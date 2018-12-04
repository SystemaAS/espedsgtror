  //this variable is a global jQuery var instead of using "$" all the time. Very handy
  var jq = jQuery.noConflict();
  var counterIndex = 0;
  var BLOCKUI_OVERLAY_MESSAGE_DEFAULT = "Please wait...";
  
  function setBlockUI(element){
	  jq.blockUI({ css: { fontSize: '22px' }, message: BLOCKUI_OVERLAY_MESSAGE_DEFAULT});
  }
  
  jq(document).ready(function() {
		//jq('#updCancelButton').hide();
  });
  
  //Global functions
  function g_getCurrentYearStr(){
	  return new Date().getFullYear().toString();
  }
  function g_getCurrentMonthStr(){
	  var currentMonth = new Date().getMonth() + 1;
	  var currentMonthStr = currentMonth.toString();
	  if (currentMonth < 10) { currentMonthStr = '0' + currentMonth; }
	  return currentMonthStr;
  }
 
  //Links on child windows
  jq(function() {
	  //frisokvei koder child window search
	  jq('#fskodeIdLink').click(function() {
		jq('#fskodeIdLink').attr('target','_blank');  
		window.open('transportdisp_workflow_childwindow_frisokveicodes.do?action=doFind',"frisokveiCodesWin","top=300px,left=50px,height=600px,width=550px,scrollbars=no,status=no,location=no");
	  });
	  //frisokvei dok.koder child window search
	  jq('#fsdokkIdLink').click(function() {
		jq('#fsdokkIdLink').attr('target','_blank');  
		window.open('transportdisp_workflow_childwindow_frisokveidoccodes.do?action=doFind',"frisokveiDocCodesWin","top=300px,left=150px,height=600px,width=550px,scrollbars=no,status=no,location=no");
	  });
  });
  
 
  
  //-------------------
  //Fetch specific line
  //-------------------
  function getItemData(record) {
		var FIELD_SEPARATOR = "_";
	  	var htmlValue = record.id;
	  	var applicationUser = jq('#applicationUser').val();
	  	//alert(htmlValue);
	  	htmlValue = htmlValue.replace("recordUpdate_","");
	  	var fields = htmlValue.split(FIELD_SEPARATOR);
	  	var requestString = "user=" + jq('#applicationUser').val() + "&avd=" + jq('#avd').val() + "&opd=" + jq('#opd').val() + "&mode=I" +
	  						"&o_fskode=" + fields[0] + "&o_fssok=" + fields[1];
	  	//DEBUG--> alert(requestString);
	  	//http://user=JOVO&avd=75&opd=103&mode=I&o_fskode=IFB&o_fssok=70701550001424817 
	  	
	  	jq.ajax({
	  	  type: 'GET',
	  	  url: 'getFrisokveiDetailLine_Landimport.do',
	  	  data: { applicationUser : applicationUser, 
	  		  	  requestString : requestString }, 
	  	  dataType: 'json',
	  	  cache: false,
	  	  contentType: 'application/json',
	  	  success: function(data) {
	  		var len = data.length;
			for ( var i = 0; i < len; i++) {
				//alert(data[i].fask);
				
				jq('#isModeUpdate').val("");jq('#isModeUpdate').val("true");
				jq('#fskodeKey').val("");jq('#fskodeKey').val(data[i].kode); //hidden field
				jq('#fssokKey').val("");jq('#fssokKey').val(data[i].sok); //hidden field
				//read only field(s)
				jq('#fskode').val("");
				jq('#fskode').prop("readonly", true);
				jq('#fskode').removeClass("inputTextMediumBlueMandatoryField");
				jq('#fskode').addClass("inputTextReadOnly");
				//fields
				jq('#fskode').val("");jq('#fskode').val(data[i].kode);
				jq('#fssok').val("");jq('#fssok').val(data[i].sok);
				jq('#fsdokk').val("");jq('#fsdokk').val(data[i].dokk);
				/*
				jq('#buoavd').val("");
				if(data[i].buoavd!='0'){
					jq('#buoavd').val(data[i].buoavd);
				}
				*/
					
			}
	  	  },
	  	  error: function() {
	  	    alert('Error loading ...');
	  	  }
	  	});
	  	
	}

  	//---------------------------------------
	//DELETE Invoice line
	//This is done in order to present a jquery
	//Alert modal pop-up
	//----------------------------------------
	function doDeleteItemLine(element){
		//start
		//avd_${record.fsavd}@opd_${record.fsopd}@kode_${record.fskode}@sok_${record.fssok}
		var record = element.id.split('@');
		var avd = record[0].replace("avd_","");
		var opd = record[1].replace("opd_","");
		var id = record[2].replace("id_","");
		var sign = record[3].replace("sign_","");
	
		//Start dialog
		jq('<div></div>').dialog({
			modal: true,
			title: "Dialog - Slett fraktbrev: " + id,
			buttons: {
		        Fortsett: function() {
	      		jq( this ).dialog( "close" );
		            //do delete
		            jq.blockUI({ css: { fontSize: '22px' }, message: BLOCKUI_OVERLAY_MESSAGE_DEFAULT});
		            window.location = "tror_mainorderland_freightbill_list_edit.do?action=doDelete" + "&dfavd=" + avd + "&dfopd=" + opd + "&dffbnr=" + id + "&sign=" + sign ;
		        },
		        Avbryt: function() {
		            jq( this ).dialog( "close" );
		        }
			},
			open: function() {
		  		  var markup = "Er du sikker på at du vil slette denne?";
		          jq(this).html(markup);
		          //make Cancel the default button
		          jq(this).siblings('.ui-dialog-buttonpane').find('button:eq(1)').focus();
			}
		});  //end dialog
	}
	
	//-------------------
	  //Datatables jquery
	  //-------------------
	  //private function
	  function filterGlobal () {
	    jq('#tblMain').dataTable().search(
	    	jq('#tblMain_filter').val()
	    ).draw();
	  }

	  jq(document).ready(function() {
	    //init table (no ajax, no columns since the payload is already there by means of HTML produced on the back-end)
	    jq('#tblMain').dataTable( {
	  	  //"dom": '<"top">t<"bottom"f><"clear">',
	    	"searchHighlight": true,
	    	"dom": '<"top"i>rt<"bottom"f><"clear">',
			  "scrollY":  "200px",
			  "order": [ [ 1, "asc" ] ],
			  "scrollCollapse":  true,
			  "lengthMenu": [ 25, 50]
		  });
	    //event on input field for search
	    jq('input.tblMain_filter').on( 'keyup click', function () {
	    		filterGlobal();
	    });
		
	  });
	 
  