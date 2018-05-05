	//this variable is a global jQuery var instead of using "$" all the time. Very handy
  	var jq = jQuery.noConflict();
  	 var BLOCKUI_OVERLAY_MESSAGE_DEFAULT = "Please wait...";
  	//----------
  	//functions
  	//----------
	jq(function() {
		jq("#customerForm").submit(function() {
			  jq.blockUI({ css: { fontSize: '22px' }, message: BLOCKUI_OVERLAY_MESSAGE_DEFAULT}); 
		 });
		
		jq('#customerList').on('click', 'td', function(){
			  var id = this.id;
			  var record = id.split('@');
			 
			  var knr = record[0].replace("knr", "");
			  var knavn = record[1].replace("knavn", "");
			  var adr1 = record[2].replace("kadr1", "");
			  var adr3 = record[3].replace("kadr3", "");
			  var postnr = record[4].replace("kpostnr", "");
			  var land = record[5].replace("kland", "");
			  var eori = record[6].replace("keori", "");
			  var callerType = record[7].replace("ctype", "");
			  var adr2 = record[8].replace("kadr2", "");
			  var firma = record[9].replace("firma", "");
			  var orgnr = record[10].replace("syrg", "");
			  
			  //addressing a parent field from this child window
			  //default on Generella Avd
			  opener.jq('#koaknr').val(knr);
			  
			  
			  //TROR - Oppdragsreg.	  
			  if (callerType == 'tror_ag'){ //Agent
				  opener.jq('#hekna').val(knr);
				  opener.jq('#henaa').val(knavn);
			 
			  }else if (callerType == 'tror_se'){ //Seller
				  opener.jq('#hekns').val(knr);
				  opener.jq('#syrg').val(orgnr);
				  var compoundName = knavn + " - " + adr3 + " " + postnr;
				  opener.jq('#whenas').val(compoundName);
				  //?
				  //opener.jq('#todo').val(knr);
				  opener.jq('#henas').val(knavn);
				  //opener.jq('#todo').val(eori);
				  opener.jq('#heads1').val(adr1);
				  opener.jq('#heads2').val(adr2);
				  opener.jq('#heads3').val(adr3 + " " + postnr);
				  //opener.jq('#todo').val(land);
			  
			  }else if (callerType == 'tror_sefm'){ //Seller Fakt.mott.
				  opener.jq('#heknsf').val(knr);
				  var compoundName = knavn + " - " + adr3 + " " + postnr;
				  opener.jq('#whenasf').val(compoundName);
			  
			  }else if (callerType == 'tror_by'){ //Buyer
				  opener.jq('#heknk').val(knr);
				  var compoundName = knavn + " - " + adr3 + " " + postnr;
				  opener.jq('#whenak').val(compoundName);
				  //?
				  //opener.jq('#todo').val(knr);
				  opener.jq('#henak').val(knavn);
				  //opener.jq('#todo').val(eori);
				  opener.jq('#headk1').val(adr1);
				  opener.jq('#headk2').val(adr2);
				  opener.jq('#headk3').val(adr3 + " " + postnr);
				  //opener.jq('#todo').val(land);
				  
			  }else if (callerType == 'tror_byfm'){ //Buyer Faktmott.
				  opener.jq('#heknkf').val(knr);
				  var compoundName = knavn + " - " + adr3 + " " + postnr;
				  opener.jq('#whenakf').val(compoundName);
				  
			  }else if (callerType == 'tror_car'){ //Carrier
				  opener.jq('#heknt').val(knr);
				  var compoundName = knavn + " - " + adr3 + " " + postnr;
				  opener.jq('#ownheknt').val(compoundName);
			  
			  }else if (callerType == 'tror_by_fb'){ //Buyer - fraktbrev
				  opener.jq('#dfknsm').val(knr);
				  var compoundName = knavn + " - " + adr3 + " " + postnr;
				  opener.jq('#whenak').val(compoundName);
				  //?
				  //opener.jq('#todo').val(knr);
				  opener.jq('#dfnavm').val(knavn);
				  //opener.jq('#todo').val(eori);
				  opener.jq('#dfad1m').val(adr1);
				  opener.jq('#dfad2m').val(adr2);
				  opener.jq('#dfad3m').val(adr3 + " " + postnr);
				  //opener.jq('#todo').val(land);
				  
			  }else if (callerType == 'tror_se_fb'){ //Seller fraktbrev
				  opener.jq('#dfknss').val(knr);
				  var compoundName = knavn + " - " + adr3 + " " + postnr;
				  opener.jq('#whenas').val(compoundName);
				  //?
				  //opener.jq('#todo').val(knr);
				  opener.jq('#dfnavs').val(knavn);
				  //opener.jq('#todo').val(eori);
				  opener.jq('#dfad1s').val(adr1);
				  opener.jq('#dfad2s').val(adr2);
				  opener.jq('#dfad3s').val(adr3);
				  opener.jq('#dfpnls').val(postnr);
				  
				  //opener.jq('#todo').val(land);
			  
			  } else if (callerType == 'tror_annen_fb'){ //Annen fraktbetaler fraktbrev
				  opener.jq('#dfknsx').val(knr);
				  //var compoundName = knavn + " - " + adr3 + " " + postnr;
				  //opener.jq('#whenas').val(compoundName);
				  //?
				  //opener.jq('#todo').val(knr);
				  opener.jq('#dfnavx').val(knavn);
				  //opener.jq('#todo').val(eori);
				  opener.jq('#dfad1x').val(adr1);
				  opener.jq('#dfad2x').val(adr2);
				  opener.jq('#dfad3x').val(adr3);
				  // TODO opener.jq('#dfpnls').val(postnr);
				  
				  //opener.jq('#todo').val(land);
			  
			  } else if (callerType =='tror_flyiavs'){
				  opener.jq('#hekns').val(knr);
				  opener.jq('#ownHekns').val(knavn);
				  
			  }
			  
			  
			  
			  //close child window
			  window.close();
		  });
	});
	

	
	//======================
    //Datatables jquery 
    //======================
    //private function [Filters]
    function filterGeneralCode () {
    		jq('#customerList').DataTable().search(
      		jq('#customerList_filter').val()
    		).draw();
    } 
	//Init datatables
    jq(document).ready(function() {
  	  //-----------------------
      //table [General Code List]
  	  //-----------------------
    	  jq('#customerList').dataTable( {
    		  "dom": '<"top"fli>rt<"bottom"p><"clear">',
    		  "lengthMenu": [ 75, 100, 200, 500]
    	  });
      //event on input field for search
      jq('input.customerList_filter').on( 'keyup click', function () {
      		filterGeneralCode();
      });
      
    });   
  	
  	
	