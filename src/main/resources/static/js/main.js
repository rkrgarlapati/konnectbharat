
var regFormMandatoryFields = ["first_name", "second_name", "area","phone","city","state","password","reenterPassword"];
var rentalFormMandatoryFields = ["rental_party","rental_phone"];
var saleFormMandatoryFields = ["sale_party","sale_phone"];
var matriFormMandatoryFields = ["matri_party_name","matri_agreement_type","matri_phone"];
var newEmpRegMandatoryFields = ["emp_firstName","emp_lastName","emp_userid","emp_password","emp_reenterpassword"];
$(document).ready(function(){
	 
	 
	/*show mandatory icon inline elements*/
	$.each(regFormMandatoryFields, function( index, value ) {
		showErrIcon(1,value);
		});
	$.each(rentalFormMandatoryFields, function( index, value ) {
		showErrIcon(1,value);
		});
	$.each(saleFormMandatoryFields, function( index, value ) {
		showErrIcon(1,value);
		});
	$.each(matriFormMandatoryFields, function( index, value ) {
		showErrIcon(1,value);
		});
	$.each(newEmpRegMandatoryFields, function( index, value ) {
		showErrIcon(1,value);
		});
	
	
/** STARTING OnTyping FUNCTION **/	
	$('#rental_party,#sale_party,#matri_party_name').on('input', function() {
		var input = $(this);
		var span_id='showError'+ input.attr('id');
		var x = '#'+span_id;
				
		if(input.val().trim().length >=2 && input.val().trim().length<=35){
			$(input).removeClass("invalid").addClass("valid");	
			if($(x).length >=1){
				$(x).remove();
			}
		}
		
		
		showMandatoryIcon(this);
		enableDisableSubmit(2,this);
		enableDisableSubmit(3,this);
	});
	
	
	$('#first_name,#second_name,#area,#city,#state,#password,#reenterPassword').on('input', function() {
		var input = $(this);
		var span_id='showError'+ input.attr('id');
		var x = '#'+span_id;
				
		if(input.val().trim().length >=2 && input.val().trim().length<=35){
			$(input).removeClass("invalid").addClass("valid");	
			if($(x).length >=1){
				$(x).remove();
			}
		}
		
		if($(this).val().trim().length>0){
			$(this).parent().find('.innerErrSpn').remove();
		}
		if($(this).val().trim().length==0){
			showErrIcon(1,$(this).attr('id'));
		}
		
		enableDisableSubmit(1,this);
	});
	

	$('#emp_firstName,#emp_lastName,#emp_userid,#emp_password,#emp_reenterpassword').on('input', function() {
		var input = $(this);
		var span_id='showError'+ input.attr('id');
		var x = '#'+span_id;
				
		if(input.val().trim().length >=2 && input.val().trim().length<=35){
			$(input).removeClass("invalid").addClass("valid");	
			if($(x).length >=1){
				$(x).remove();
			}
		}
		
		if($(this).val().trim().length>0){
			$(this).parent().find('.innerErrSpn').remove();
		}
		if($(this).val().trim().length==0){
			showErrIcon(1,$(this).attr('id'));
		}
		
	});
	
	
	
		
	$('#phone,#rental_phone,#sale_phone,#aadharNumber,#matri_phone').on('input', function() {
		var input = $(this);
		var phone=input.val();
		var span_id='showError'+ input.attr('id');
		var x = '#'+span_id;

		if(input.attr('id')=='aadharNumber'){
			if(phone.length==12){
				$(input).removeClass("invalid").addClass("valid");	
				if($(x).length >=1){
					$(x).remove();
				}
			}
		}
		else{
			$(this).parent().find('.innerErrSpn').remove();
			if(phone.length==10){
				$(input).removeClass("invalid").addClass("valid");			
				if($(x).length >=1){
					$(x).remove();
				}
				enableDisableSubmit(2,this);
				enableDisableSubmit(3,this);
			}	else if(phone.length==0){
					showMandatoryIcon(this);
			}		
		}
	});


$("#postal,#rental_postal,#sale_postal").on('input',function(){		
	var input = $(this);	
	var postal = input.val();
	var span_id='showError'+ input.attr('id');
	var x = '#'+span_id;
	
	if(postal.length ==6){
		if($(x).length >=1){
			$(x).remove();
		}
		input.removeClass("invalid").addClass("valid");
	}
});
	
/** END OnTyping FUNCTION **/	

	
/** STARTING OnBlur FUNCTION **/	

$('#first_name,#second_name,#area,#city,#state,#password,#reenterPassword').blur('input', function() {
	var input = $(this);
	var span_id='showError'+ input.attr('id');
	var x = '#'+span_id;
	
	if($(x).length >=1){
		$(x).remove();
	}
	$(this).parent().find('.innerErrSpn').remove();
	
	if(input.val().trim().length == 0){
		if($(x).length==0){							
				$("<span/>",{ 'id' : span_id}).addClass('error glyphicon glyphicon-warning-sign span-error').text(' Field cannot be empty ').insertAfter(input);
		}
		$(input).removeClass("valid").addClass("invalid");	
		showErrIcon (1,$(input).attr('id'));
	}	
	if($(this).attr('id')!='password' && $(this).attr('id')!='reenterPassword'){
	if(!(input.val().trim().length >=2 && input.val().trim().length<=35)){
		if($(x).length==0){
			$("<span/>",{ 'id' : span_id}).addClass('error glyphicon glyphicon-warning-sign span-error').text(' Minimum characters should be 2-35 ').insertAfter(input);
		}
		$(input).removeClass("valid").addClass("invalid");					
	}	else{
		$(input).removeClass("invalid").addClass("valid");	
		//adding green tick icon
		
		showErrIcon (2,$(input).attr('id'));
		if($(x).length >=1){
			$(x).remove();
		}
	}
	} else{
		$('#reenterPassword').parent().find('.innerErrSpn').remove();
		$('#password').parent().find('.innerErrSpn').remove();
		if(input.val().trim().length<7){
				$(x).remove();
				$("<span/>",{ 'id' : span_id}).addClass('error glyphicon glyphicon-warning-sign span-error').text(' Minimum of 7 characters  ').insertAfter(input);
				if(input.val().trim().length==0){
					showErrIcon (1,'reenterPassword');
					showErrIcon (1,'password');
				}
		}else if( $('#password').val().length>0 && $('#reenterPassword').val().length>0 && $('#password').val()!=  $('#reenterPassword').val() ){
			if($(this).attr('id')=='reenterPassword'){
			$("<span/>",{ 'id' : 'showErrorreenterPassword'}).addClass('error glyphicon glyphicon-warning-sign span-error').text(' Passwords should match ').insertAfter(input);
			} else{
				if($('#password').val()!=  $('#reenterPassword').val()){
					$('#password').parent().find('.innerErrSpn').remove();
					$('#reenterPassword').parent().find('.innerErrSpn').remove();
					$('#showErrorreenterPassword').remove();
					$("<span/>",{ 'id' : 'showErrorreenterPassword'}).addClass('error glyphicon glyphicon-warning-sign span-error').text(' Passwords should match ').insertAfter($('#reenterPassword'));
					
				} else{
					$('#reenterPassword').parent().find('.innerErrSpn').remove();
					$('#password').parent().find('.innerErrSpn').remove();
					showErrIcon (2,'reenterPassword');
					showErrIcon (2,'password');
					$('#showErrorreenterPassword').remove();
				}
			}
		}else{
			$(input).removeClass("invalid").addClass("valid");	
//			$('#showErrorreenterPassword').remove();
			//adding green tick icon
			if($(this).attr('id')!='reenterPassword'){
				showErrIcon (2,$(input).attr('id'));
			}
			if($(x).length >=1){
				$(x).remove();
			}
			if($('#password').val() ==  $('#reenterPassword').val()){
				$('#reenterPassword').parent().find('.innerErrSpn').remove();
				$('#password').parent().find('.innerErrSpn').remove();
				showErrIcon (2,'reenterPassword');
				showErrIcon (2,'password');
				$('#showErrorreenterPassword').remove();
			}
			
			
		}
		
	}
	
	/*var validInputs = $('#registration_form .validinput').length;
	if(validInputs >= regFormMandatoryFields.length){
		if($(this).val().trim().length>=2){
			$('#submit_registerForm').prop('disabled','');
		}
	}*/
	
	enableDisableSubmit(1,this);
	//check and validate submit button
	
});




$('#emp_firstName,#emp_lastName,#emp_userid,#emp_password,#emp_reenterpassword').blur('input', function() {
	var input = $(this);
	var span_id='showError'+ input.attr('id');
	var x = '#'+span_id;
	
	if($(x).length >=1){
		$(x).remove();
	}
	$(this).parent().find('.innerErrSpn').remove();
	
	if(input.val().trim().length == 0){
		if($(x).length==0){							
				$("<span/>",{ 'id' : span_id}).addClass('error glyphicon glyphicon-warning-sign span-error').text(' Field cannot be empty ').insertAfter(input);
		}
		$(input).removeClass("valid").addClass("invalid");	
		showErrIcon (1,$(input).attr('id'));
	}	
	if($(this).attr('id')!='emp_password' && $(this).attr('id')!='emp_reenterpassword'){
	if(!(input.val().trim().length >=2 && input.val().trim().length<=35)){
		if($(x).length==0){
			$("<span/>",{ 'id' : span_id}).addClass('error glyphicon glyphicon-warning-sign span-error').text(' Minimum characters should be 2-35 ').insertAfter(input);
		}
		$(input).removeClass("valid").addClass("invalid");					
	}	else{
		$(input).removeClass("invalid").addClass("valid");	
		showErrIcon (2,$(input).attr('id'));
		if($(x).length >=1){
			$(x).remove();
		}
	}
	} else{
		$('#emp_reenterpassword').parent().find('.innerErrSpn').remove();
		$('#emp_password').parent().find('.innerErrSpn').remove();
		if(input.val().trim().length<7){
				$(x).remove();
				$("<span/>",{ 'id' : span_id}).addClass('error glyphicon glyphicon-warning-sign span-error').text(' Minimum of 7 characters  ').insertAfter(input);
				if(input.val().trim().length==0){
					showErrIcon (1,'emp_reenterpassword');
					showErrIcon (1,'emp_password');
				}
		}else if( $('#emp_password').val().length>0 && $('#emp_reenterpassword').val().length>0 && $('#emp_password').val()!=  $('#emp_reenterpassword').val() ){
			if($(this).attr('id')=='emp_reenterpassword'){
			$("<span/>",{ 'id' : 'showErroremp_reenterpassword'}).addClass('error glyphicon glyphicon-warning-sign span-error').text(' Passwords should match ').insertAfter(input);
			} else{
				if($('#emp_password').val()!=  $('#emp_reenterpassword').val()){
					$('#emp_password').parent().find('.innerErrSpn').remove();
					$('#emp_reenterpassword').parent().find('.innerErrSpn').remove();
					$('#showErroremp_reenterpassword').remove();
					$("<span/>",{ 'id' : 'showErroremp_reenterpassword'}).addClass('error glyphicon glyphicon-warning-sign span-error').text(' Passwords should match ').insertAfter($('#emp_reenterpassword'));
					
				} else{
					$('#emp_reenterpassword').parent().find('.innerErrSpn').remove();
					$('#emp_password').parent().find('.innerErrSpn').remove();
					showErrIcon (2,'emp_reenterpassword');
					showErrIcon (2,'emp_password');
					$('#showErroremp_reenterpassword').remove();
				}
			}
		}else{
			$(input).removeClass("invalid").addClass("valid");	
			if($(this).attr('id')!='emp_reenterpassword'){
				showErrIcon (2,$(input).attr('id'));
			}
			if($(x).length >=1){
				$(x).remove();
			}
			if($('#emp_password').val() ==  $('#emp_reenterpassword').val()){
				$('#emp_reenterpassword').parent().find('.innerErrSpn').remove();
				$('#emp_password').parent().find('.innerErrSpn').remove();
				showErrIcon (2,'emp_reenterpassword');
				showErrIcon (2,'emp_password');
				$('#showErroremp_reenterpassword').remove();
			}
			
			
		}
		
	}
	
	
});




$('#emailid').blur('input', function() {
	var input=$(this);
	var span_id='showError'+ input.attr('id');
	var x = '#'+span_id;
	var email=input.val();
	var email_regex = /^[\w\-\.\+]+\@[a-zA-Z0-9\.\-]+\.[a-zA-z0-9]{2,4}$/;

	if($(x).length ==1){
		$(x).remove();
	}
	
	/*if(email.length==0){
		$("<span/>",{ 'id' : span_id}).addClass('error glyphicon glyphicon-warning-sign span-error').text(' Field cannot be empty ').insertAfter(input);			
		$(input).removeClass("valid").addClass("invalid");			
	}*/
			
	if(email.length>0 && !(email.match(email_regex))){
		if($(x).length==0){	
			$("<span/>",{ 'id' : span_id}).addClass('error glyphicon glyphicon-warning-sign span-error').text(' Invalid email address ').insertAfter(input);
		}
		$(input).removeClass("valid").addClass("invalid");	
	}
	else{
		$(input).removeClass("invalid").addClass("valid");	
		if($(x).length >=1){
			$(x).remove();
		}
	}
});

$('#phone,#rental_phone,#sale_phone,#matri_phone').blur('input', function() {
	var input = $(this);
	var phone1=input.val();
	var span_id='showError'+ input.attr('id');
	var x = '#'+span_id;
	var phone_regex = /^[1-9]{1}[0-9]{9}$/;		
	var repetitive_digits = /^(\d)(?!\1+$)\d{9}$/;
	$(this).parent().find('.innerErrSpn').remove();
	enableDisableSubmit(2,this);
	enableDisableSubmit(3,this);
	if($(x).length >=1){
		$(x).remove();
	}
	 if(phone1.length !=10){
		if($(x).length ==1){
			$(x).remove();
		}
		if(input.attr('id')=="phone" && input.val().trim().length == 0){
			$("<span/>",{ 'id' : span_id}).addClass('error glyphicon glyphicon-warning-sign span-error').text(' Field cannot be empty ').insertAfter(".input-group-pNumber");
		}
		else{
			if($(this).val().length==0){
				showMandatoryIcon($(this));
			}
			$("<span/>",{ 'id' : span_id}).addClass('error glyphicon glyphicon-warning-sign span-error').text(' Enter 10 digit phone number ').insertAfter(".input-group-pNumber");
		}
		$(input).removeClass("valid").addClass("invalid");		
	}				
	else if(!(phone1.match(phone_regex))){
		if($(x).length ==1){
			$(x).remove();
		}
		$("<span/>",{ 'id' : span_id}).addClass('error glyphicon glyphicon-warning-sign span-error').text(' Invalid Phone Number ').insertAfter(".input-group-pNumber");
		$(input).removeClass("valid").addClass("invalid");	
	}
	else if(!(phone1.match(repetitive_digits))){
		if($(x).length ==1){
			$(x).remove();
		}
		$("<span/>",{ 'id' : span_id}).addClass('error glyphicon glyphicon-warning-sign span-error').text(' Invalid Phone Number ').insertAfter(".input-group-pNumber");
		$(input).removeClass("valid").addClass("invalid");	
	}
	else{
		$(input).removeClass("invalid").addClass("valid");	
		if($(x).length >=1){
			$(x).remove();
		}
		showErrIcon(2,$(this).attr('id'));
		enableDisableSubmit(2,this);
		enableDisableSubmit(3,this);
	}
});

$("#aadharNumber").blur('input',function(){
	
	var input = $(this);
	var span_id='showError'+ input.attr('id');
	var x = '#'+span_id;
			
	if(input.val().trim().length ==12){
		if($(x).length >=1){
			$(x).remove();
		}
		input.removeClass("invalid").addClass("valid");
	}
	else{
		if($(x).length>0 ){	
			$("<span/>",{ 'id' : span_id}).addClass('error glyphicon glyphicon-warning-sign span-error').text(' Invalid Aadhar number(12 digits) ').insertAfter(input);
			input.removeClass("valid").addClass("invalid");
		}
		
	}	
});

/*$("#sale_address1,#sale_address2").blur('input',function(){
		
		var input = $(this);
		var span_id='showError'+ input.attr('id');
		var x = '#'+span_id;
		
		var address = input.val();
		
		if(address.length >=5 && address.length <=40){
			if($(x).length >=1){
				$(x).remove();
			}
			input.removeClass("invalid").addClass("valid");
		}
		else{
			if($(x).length==0){	
				$("<span/>",{ 'id' : span_id}).addClass('error glyphicon glyphicon-warning-sign span-error').text(' Minimum characters should be 5-40 ').insertAfter(input);
			}
			input.removeClass("valid").addClass("invalid");
		}
	});*/
	


	
	$('#rental_party,#sale_party,#matri_party_name').blur('input', function() {
		var input = $(this);
		var span_id='showError'+ input.attr('id');
		var x = '#'+span_id;
		$(this).parent().find('.innerErrSpn').remove();
		
		if($(x).length >=1){
			$(x).remove();
		}
		
		if(!(input.val().trim().length >=2 && input.val().trim().length<=35)){
			if($(x).length==0){
				$("<span/>",{ 'id' : span_id}).addClass('error glyphicon glyphicon-warning-sign span-error').text(' Minimum characters should be 2-35 ').insertAfter(input);
				showMandatoryIcon($(this));
			}
			$(input).removeClass("valid").addClass("invalid");					
		}		
		else{
			$(input).removeClass("invalid").addClass("valid");	
			if($(x).length >=1){
				$(x).remove();
			}
			
				showErrIcon(2,$(this).attr('id'));
			
			enableDisableSubmit(2,this);
			enableDisableSubmit(3,this);
		}
	});
	
	
	

/** END OnBlur FUNCTION **/

	
/** STARTING OnFocus FUNCTION **/

	$("#first_name,#second_name,#phone,#emailid,#rental_party,#rental_phone,#matri_phone,#rental_address1,#rental_address2," +
		"#sale_party,#sale_phone,#sale_address1,#sale_address2,"+
		"#postal,#rental_postal,#sale_postal").focus(function(){
		var input=$(this);
		if(input.hasClass("invalid")){
			$(":focus").css("outline","0 none");
		}
	});
	
/** END OnFocus FUNCTION **/	
	
	
/** KeyDown length=35**/
	$("#first_name,#second_name,#rental_party,#sale_party").keydown(function(event){
		var input=$(this);
		var x=event.which || event.keyCode ;
		console.log(x);
		
		if((x >=48 && x <=57)|| (x >=219 && x <=222)||(x>=186 && x<=192)){
			event.preventDefault();
			console.log("success");
		}
		
		if(input.val().trim().length>=35){
			if(x==8 || x==9 || x==13 || x>=16 && x<=18 || x==46   ){
				//do nothing
			}
			else{
				event.preventDefault();
			}
		}
	});
	

	
	
	/* Numbers & special characters not allowed to be typed */	
	$("#city,#state," +
		"#rental_city,#rental_state,#rental_country," +
		"#sale_city,#sale_state,#sale_country,#sale_referal,#rental_party").keydown(function(event){
		var x=event.which || event.keyCode;
		
		if((x >=48 && x <=57)||(x >=219 && x <=222)||(x>=186 && x<=192)){
			event.preventDefault();
		}
	});
	
	
	$("#matri_party_name,#matri_city," +
			"#matri_state,#matri_country," +
			"#matri_bride_name,#matri_caste,#matri_sub_caste").keydown(function(event){
			var x=event.which || event.keyCode;
			
			if((x >=48 && x <=57)||(x >=219 && x <=222)||(x>=186 && x<=192)){
				event.preventDefault();
			}
		});
	
	
	
/** STARTING OnKeyPress FUNCTION **/	
		
	/* Email field keypress validation 33,35,36,37,38 */	
	$("#emailid").keypress(function(event){
		var x=event.which || event.keyCode;
		if((x==32 || x==34 || x==40 || x==41 ||x==44 || x==62 || x==126 || x==96 )||(x >=58 && x <= 60)||(x >=91 && x <=94)){
			event.preventDefault();
		}
	});
	
/* Alphabets & special characters not allowed to be typed  length=6*/	
	$("#postal,#rental_postal,#sale_postal,#matri_postal").keypress(function(event){
		var input = $(this);
		var x=event.which || event.keyCode;
		if((x >=97 && x <=122)||(x >= 65 && x<= 90)||(x >=32 && x <=47)||(x >=58 && x <= 64)||(x >=91 && x <=96)||(x >=123 && x <=126)){
			event.preventDefault();
		}
		if(input.val().trim().length>=6){
			if(x==8 || x==9 || x==13 || x>=16 && x<=18 || x==46   ){
				//do nothing
			}
			else{
				event.preventDefault();
			}
		}
	});
	
	
	$("#matri_height").keypress(function(evt){
		var input = $(this).val();
	if((evt.charCode>= 48 && evt.charCode <= 57) || evt.charCode== 46 ||evt.charCode == 0){
		if(input.indexOf('.') > -1){
		 if(evt.charCode== 46 || input.length>3)
		  evt.preventDefault();
		}
		}else{
		evt.preventDefault();
		};
	});	
		
	
	$("#aadharNumber").keypress(function(event){
		var input = $(this);
		var x=event.which || event.keyCode;
		if((x >=97 && x <=122)||(x >= 65 && x<= 90)||(x >=32 && x <=47)||(x >=58 && x <= 64)||(x >=91 && x <=96)||(x >=123 && x <=126)){
			event.preventDefault();
		}
		if(input.val().trim().length>=12){
			if(x==8 || x==9 || x==13 || x>=16 && x<=18 || x==46   ){
				//do nothing
			}
			else{
				event.preventDefault();
			}
		}
	});
	
	$("#phone,#rental_phone,#sale_phone,#matri_phone").keypress(function(event){
			var input = $(this);
			var x=event.which || event.keyCode;
			if((x >=97 && x <=122)||(x >= 65 && x<= 90)||(x >=32 && x <=47)||(x >=58 && x <= 64)||(x >=91 && x <=96)||(x >=123 && x <=126)){
				event.preventDefault();
			}
			if(input.val().trim().length>=10){
				if(x==8 || x==9 || x==13 || x>=16 && x<=18 || x==46){
					//do nothing
				}
				else{
					event.preventDefault();
				}
			}
		});
	
/* special characters not allowed to be typed */
	$("#panNumber,#license").keypress(function(event){
		var x=event.which || event.keyCode;
		if((x >=32 && x <=47)||(x >=58 && x <= 64)||(x >=91 && x <=96)||(x >=123 && x <=126)){
			event.preventDefault();
		}
	});
	
	
	/*44(comma) ,45(dash),47(backslash) allowed*/
	//REMOVED #address1,#address2 ,#rental_address1,#rental_address2,#sale_address1,#sale_address2 as it should allow all keyboard inputs
	$("#rental_area,#sale_area,#area").keypress(function(event){
		var input=$(this);
		var x=event.which || event.keyCode;
		
		if((x >32 && x <=43)||(x==46)||(x >=58 && x <= 64)||(x >=91 && x <=96)||(x >=123 && x <=126)){
			event.preventDefault();
		}
		
		if(input.val().trim().length>=40){
			if(x==8 || x==9 || x==13 || x>=16 && x<=18 || x==46   ){
				//do nothing
			}
			else{
				event.preventDefault();
			}
		}
	});
	
	$("#rental_rent,#sale_rent,#rental_advance,#advance,#r_park_two,#parking_two,#r_park_four,#parking_four,#r_maintenance,#maintenance,#sale_amount,#r_rent_period,#rent_period").keypress(function(event){
		var x=event.which || event.keyCode;
		if((x >=97 && x <=122)||(x >= 65 && x<= 90)||(x >=33 && x <=45)||(x==47)||(x==58)||(x==59)||(x >=60 && x <= 64)||(x >=91 && x <=96)||(x >=123 && x <=126)){
			event.preventDefault();
		}
	});
		
	/*Enter key behave as tab key except Submit button*/	
	$(document).on('keypress', 'input', function(e) {	
        if (e.which == 13 || e.keyCode == 13 ) {       
        
        	var x = document.activeElement.id;
        	var y = $("form input:submit").attr('id')
        	if(x==y){
        		if(x=="submit_registerForm"){
        		submitForm(e);
        		}
        		else if(x=="submit_rentalForm"){
        			submitRentForm(e,$('#rental_form').attr('action'));
        		}
        		else if(x=="submit_saleForm"){
        			submitSaleForm(e,$('#sale_form').attr('action'));
        		}
        		else{
        			/*add submit rental/sale form function*/
        			event.preventDefault();
        		}
        	}
        	else{
            var inputs = $(this).parents("form").eq(0).find(":input");
            var idx = inputs.index(this);

            if (idx == inputs.length - 1) {
                inputs[0].select()
            } else {
                inputs[idx + 1].focus();
                try{
                	inputs[idx + 1].select();
                }
                catch(err) {
                    // handle objects not offering select
                }
            }
            return false;
        }
       }
    });
	
	
/** END OnKeyPress FUNCTION **/		
	
	
	$("#registration_form").submit(function(event){	
		if($('#registration_form').attr('action').indexOf('cancelRegForm')<0){
			submitForm(event);
		}
			
	});
	$("#rental_form").submit(function(event){	
		if($('#rental_form').attr('action').indexOf('cancelRentalForm')<0){
			submitRentForm(event,$('#rental_form').attr('action'));
		}
			
	});
	$("#sale_form").submit(function(event){	
		if($('#sale_form').attr('action').indexOf('cancelSaleForm')<0){
			submitSaleForm(event,$('#sale_form').attr('action'));
		}
			
	});
	
	$("#matrimony_form").submit(function(event){	
		if($('#matrimony_form').attr('action').indexOf('cancelMatrimonyForm')<0){
			submitMatriForm(event,$('#matrimony_form').attr('action'));
		}
			
	});
	
	$("#contact_form").submit(function(event){	
		if($('#contact_form').attr('action').indexOf('cancelContactForm')<0){
			submitContactForm(event,$('#contact_form').attr('action'));
		}
			
	});
	
	$("#emp_registration_form").submit(function(event){	
		submitEmpRegistrationForm(event);	
	});


	function submitContactForm(event,actionUrl){
		if($('#contactpopupflg').val()=='true'){
//			$("#drilldownModel").modal('hide');
			event.preventDefault();
			submitFormFromEmpSearch(4,$('#elementId').val(),actionUrl);
		}
	}
	
	function submitEmpRegistrationForm(event){
		
		var form_data=$("#emp_registration_form").serializeArray();
		var checkError=true;
		var error_flag=false;
		for(var input in form_data){	
			var checkElement=$("#"+form_data[input]['name']);
			var x = checkElement[0].id;
			var span_id='showError'+x;
			var y = '#'+span_id;
		if(checkElement.hasClass('invalid')){
			error_notPresent=false;	
			error_flag=true;
		}			
		else if(checkElement.val()==0){
			
			$("<span/>",{ 'id' : span_id}).addClass('error glyphicon glyphicon-warning-sign span-error').text(' Field cannot be empty ').insertAfter(checkElement);	
			
			checkElement.removeClass("valid").addClass("invalid");	
			error_free=false;
			error_flag=true;
		}			
	}
		
		for(var input in form_data){	
			var checkElement=$("#"+form_data[input]['name']);
			if(checkElement.hasClass('invalid')){
				checkError=false;	
				error_flag=true;
			}
		}
		if(error_flag){
			if(!checkError){	
//				alert("Please correct values of fields");	
				$("#myModal").modal(); 
				event.preventDefault();	
			}
		}
		else{
			//alert('No errors: Form will be submitted');
		}	
	}
	
	function submitMatriForm(event,actionUrl){
		var form_data=$("#matrimony_form").serializeArray();
		var checkError=true;
		var error_flag=false;
		var a=form_data.slice(0,3);			
		for(var input in a){	
			var checkElement=$("#"+a[input]['name']);
			var x = checkElement[0].id;
			var span_id='showError'+x;
			var y = '#'+span_id;
		if(checkElement.hasClass('invalid')){
			error_notPresent=false;	
			error_flag=true;
		}			
		else if(checkElement.val()==0){
			
			if(x=="matri_phone"){
				$("<span/>",{ 'id' : span_id}).addClass('error glyphicon glyphicon-warning-sign span-error').text(' Field cannot be empty ').insertAfter(".input-group-pNumber");
			}else if(x=="matri_agreement_type"){
				$("<span/>",{ 'id' : span_id}).addClass('error glyphicon glyphicon-warning-sign span-error').text(' Please select a Agreement Type ').insertAfter(checkElement);
			}
			else{
				$("<span/>",{ 'id' : span_id}).addClass('error glyphicon glyphicon-warning-sign span-error').text(' Field cannot be empty ').insertAfter(checkElement);
			}	
			
			checkElement.removeClass("valid").addClass("invalid");	
			error_free=false;
			error_flag=true;
		}			
	}
		
		for(var input in form_data){	
			var checkElement=$("#"+form_data[input]['name']);
			if(checkElement.hasClass('invalid')){
				checkError=false;	
				error_flag=true;
			}
		}
		if(error_flag){
			if(!checkError){	
//				alert("Please correct values of fields");	
				$("#myModal").modal(); 
				event.preventDefault();	
			}
		}
		else{
			if($('#matripopupflg').val()=='true'){
//			$("#drilldownModel").modal('hide');
            event.preventDefault();	
            submitFormFromEmpSearch(3,$('#elementId').val(),actionUrl);
			}
		}		
	}
	
	
	
	/*function called while submitting registration form*/		
	function submitForm(event){	
		var form_data=$("#registration_form").serializeArray();
		var error_free=true;
		var error_notPresent=true;	
		var checkError=true;
		var error_flag=false;
		
		
		/*check for non-mandatory fields*/
		var y = form_data.slice(4,12);
		var z = form_data.slice(13,14);		
		var checkForm = y.concat(z);
		
		for(var input in checkForm){	
			var checkElement=$("#"+checkForm[input]['name']);
			if(checkElement.val()==0){
				checkElement.removeClass("invalid").addClass("valid");
				var x = checkElement[0].id;
				var span_id='showError'+x;
				var y = '#'+span_id;
				$(y).remove();
			}
			/*if(checkElement.hasClass('invalid')){
				checkError=false;	
				error_flag=true;
			}*/
		}
		
		/*check for mandatory fields*/
		var a=form_data.slice(0,4);
		var password=form_data.slice(4,6);
		var b = form_data.slice(11,14);			
		var filterElement = a.concat(b).concat(password);
			
		for(var input in filterElement){			
			var checkElement=$("#"+filterElement[input]['name']);
			var x = checkElement[0].id;
			var span_id='showError'+x;
			var y = '#'+span_id;
		if(checkElement.hasClass('invalid')){
			error_notPresent=false;	
			error_flag=true;
		}			
		else if(checkElement.val()==0 && $(checkElement).attr('id')!='emailid'){
			if($(y).length==0){
				if(x=="phone"){
					$("<span/>",{ 'id' : span_id}).addClass('error glyphicon glyphicon-warning-sign span-error').text(' Field cannot be empty ').insertAfter(".input-group-pNumber");
				}
				else{
					$("<span/>",{ 'id' : span_id}).addClass('error glyphicon glyphicon-warning-sign span-error').text(' Field cannot be empty ').insertAfter(checkElement);
				}			
			}
			checkElement.removeClass("valid").addClass("invalid");	
			error_free=false;
			error_flag=true;
		}			
	}
		if(error_flag){

			$("#myModal").modal(); 
			event.preventDefault();
			/*if (!error_free){			
				alert("Please fill all the mandatory fields");	
				
			}
			if(!error_notPresent){	
				alert("Please correct values of mandatory fields");	
				event.preventDefault();	
			}
			if(!checkError){	
				alert("Please correct values of fields");	
				event.preventDefault();	
			}*/
		}
		else{
			//alert('No errors: Form will be submitted');
		}
	}
	
	
	/*function called while submitting rental form*/
	function submitRentForm(event,actionUrl){	
		var form_data=$("#rental_form").serializeArray();
		var checkError=true;
		var error_flag=false;
		
		var a=form_data.slice(0,3);			
		for(var input in a){			
			var checkElement=$("#"+a[input]['name']);
			var x = checkElement[0].id;
			var span_id='showError'+x;
			var y = '#'+span_id;
		if(checkElement.hasClass('invalid')){
			error_notPresent=false;	
			error_flag=true;
		}			
		else if(checkElement.val()==0  && x!='agreement_type'){
			
			if(x=="rental_phone"){
				$("<span/>",{ 'id' : span_id}).addClass('error glyphicon glyphicon-warning-sign span-error').text(' Field cannot be empty ').insertAfter(".input-group-pNumber");
			}
			else{
				$("<span/>",{ 'id' : span_id}).addClass('error glyphicon glyphicon-warning-sign span-error').text(' Field cannot be empty ').insertAfter(checkElement);
			}	
			
			checkElement.removeClass("valid").addClass("invalid");	
			error_free=false;
			error_flag=true;
		}			
	}
		
		
		for(var input in form_data){	
			var checkElement=$("#"+form_data[input]['name']);
			if(checkElement.hasClass('invalid')){
				checkError=false;	
				error_flag=true;
			}
		}
		if(error_flag){
			if(!checkError){	
//				alert("Please correct values of fields");
				$("#myModal").modal(); 
				event.preventDefault();	
			}
		}
		else{

			if($('#rentalpopupflg').val()=='true'){
//			$("#drilldownModel").modal('hide');
				event.preventDefault();
				submitFormFromEmpSearch(1,$('#elementId').val(),actionUrl);
			}
		}		
	}
	
	/*function called while submitting sales form*/
	function submitSaleForm(event,actionUrl){	
		var form_data=$("#sale_form").serializeArray();
		var checkError=true;
		var error_flag=false;
		
		var a=form_data.slice(0,3);			
		for(var input in a){			
			var checkElement=$("#"+a[input]['name']);
			var x = checkElement[0].id;
			var span_id='showError'+x;
			var y = '#'+span_id;
		if(checkElement.hasClass('invalid')){
			error_notPresent=false;	
			error_flag=true;
		}			
		else if(checkElement.val()==0 && x!='agreement_type'){
			
			if(x=="sale_phone"){
				$("<span/>",{ 'id' : span_id}).addClass('error glyphicon glyphicon-warning-sign span-error').text(' Field cannot be empty ').insertAfter(".input-group-pNumber");
			}
			else{
				$("<span/>",{ 'id' : span_id}).addClass('error glyphicon glyphicon-warning-sign span-error').text(' Field cannot be empty ').insertAfter(checkElement);
			}	
			
			checkElement.removeClass("valid").addClass("invalid");	
			error_free=false;
			error_flag=true;
		}			
	}
		
		for(var input in form_data){	
			var checkElement=$("#"+form_data[input]['name']);
			if(checkElement.hasClass('invalid')){
				checkError=false;	
				error_flag=true;
			}
		}
		if(error_flag){
			if(!checkError){	
//				alert("Please correct values of fields");	
				$("#myModal").modal(); 
				event.preventDefault();	
			}
		}
		else{
			//alert('No errors: Form will be submitted');
			
			if($('#salepopupflg').val()=='true'){
				event.preventDefault();	
//			$("#drilldownModel").modal('hide');
			 submitFormFromEmpSearch(2,$('#elementId').val(),actionUrl);
			}
		}		
	}
	
	//to show error icon inside html elements while validating
	
	function showMandatoryIcon(obj){
		if($(obj).val().trim().length>0){
			$(obj).parent().find('.innerErrSpn').remove();
		}
		if($(obj).val().trim().length==0){
			showErrIcon(1,$(obj).attr('id'));
		}
	}
	function enableDisableSubmit(id, obj){
		
		/*var formBtnName = '';
		var varArry;
		var  formName; 
		if(id==1){
			formBtnName = 'submit_registerForm';
			varArry = regFormMandatoryFields;
			formName = 'register_form';
		} else if(id==2){
			formBtnName = 'submit_rentalForm';
			varArry = rentalFormMandatoryFields;
			formName='rent_form';
		}else if(id==3){
			formBtnName = 'submit_saleForm';
			varArry = saleFormMandatoryFields;
			formName='sale_form';
		}
//		$('#'+formBtnName).prop('disabled','true');
		//check and enable submit button
		var validInputs = $('#'+formName+' .validinput').length;
		if(validInputs >= varArry.length){
			if($(obj).val().trim().length>=2){
				$('#'+formBtnName).prop('disabled','');
			}
		}*/
	}

	$( "#submit_rental_activate,#submit_rental_update" ).click(function() {
		submitRentForm(event,$(this).attr('formaction'));
	});
	$( "#submit_sale_activate,#submit_sale_update" ).click(function() {
		submitSaleForm(event,$(this).attr('formaction'));
	});
	$( "#submit_matrimony_activate,#submit_matrimony_update" ).click(function() {
		submitMatriForm(event,$(this).attr('formaction'));
	});
});

function showErrIcon(msgId,elementId){
	
	var errInnerHtml = '';
	switch (msgId) {
    case 1:
    	errInnerHtml = "<span class='innerErrSpn'><i style='color:red;font-size:8px' class='fa fa-asterisk' aria-hidden='true'></i></span>";
        break;
    case 2:
    	errInnerHtml = "<span class='innerErrSpn validinput'><i style='color:#1C9963;font-size:17px' class='fa fa-check-circle'></i></span>";
        break;
    case 3:
    	errInnerHtml = "<span class='innerErrSpn'><i style='color:#1C9963;font-size:20px' class='fa fa-check-circle'></i></span>";
        break;
  
	}
	$('#'+elementId).after(errInnerHtml);
}
function callCancelEvent(obj){
	if($(obj).attr('id') == 'cancel_rentalForm'){
	
		$('#rental_form').attr('action', "/cancelRentalForm").submit();
	} else if($(obj).attr('id') == 'cancel_saleForm'){
		$('#sale_form').attr('action', "/cancelSaleForm").submit();
	}else if($(obj).attr('id') == 'cancel_registerForm'){
		$('#registration_form').attr('action', "/cancelRegForm").submit();
	}else if($(obj).attr('id') == 'cancel_matrimonyForm'){
		$('#matrimony_form').attr('action', "/cancelMatrimonyForm").submit();
	}else if($(obj).attr('id') == 'cancel_contactForm'){
		$('#contact_form').attr('action', "/cancelContactForm").submit();
	}
}

function validateAndLogin(){
	var errmsg = '';
	var userId = $('#userId').val();
	var password =  $('#login_password').val();
	$('#login_password').focus();
	if(userId.length>0 && password.length>0){
		$('#login_form').submit();
	} else if(userId.length==0 && password.length==0){
		errmsg="User ID and Password cannot be left blank";
	} else if(userId.length==0){
		errmsg="Field User ID cannot be left blank";
	}else {
		errmsg="Field Password cannot be left blank";
	}
	if(errmsg.length>0){
		$('#loginErrDiv span').text(errmsg);
		$('#loginErrDiv').show();
		
	}
}



function processEmpLogin(){
	var errmsg = '';
	var userId = $('#emp_login_userid').val();
	var password =  $('#emp_login_password').val();
	$('#emp_login_password').focus();
	if(userId.length>0 && password.length>0){
		$('#emp_login_form').submit();
	} else if(userId.length==0 && password.length==0){
		errmsg="User ID and Password cannot be left blank";
	} else if(userId.length==0){
		errmsg="Field User ID cannot be left blank";
	}else {
		errmsg="Field Password cannot be left blank";
	}
	if(errmsg.length>0){
		$('#emploginErrDiv span').text(errmsg);
		$('#emploginErrDiv').show();
		
	}
}


function agreementPick(){
	
	$("#agreementPickModel").modal(); 
	$.get("/viewAgreements", function(data, status){
        $('#agreemnts').html(data);
    });
	
	
}

function getDrilldownPg(page,saID) {
	$("#drilldownModel").modal();
	$.get("/getDrilldownPg/"+page+"/"+saID, function(data, status) {
		$('#drilldown_popup').html(data);
		if (page == 'TENANT' || page == 'OWNER') {
			$('.rentalForm_head').hide()
			$('#rent_form').css('border', 'none');
			$('.modal-title').text('Rental Form');
		} else if(page=='SELL' || page=='BUY'){
			$('.saleForm_head').hide()
			$('#sales_form').css('border', 'none');
			$('.modal-title').text('Sales Form');
		} else if(page=='BRIDE' || page=='GROOM'){
			$('.matrimonyForm_head').hide()
			$('#matri_form').css('border', 'none');
			$('.modal-title').text('Matrimony Form');
		}else{
			$('.contact_form_head').hide()
			$('#con_contact_form').css('border', 'none');
			$('.modal-title').text('Contact Form');
		}
	});

}
/*
 * function loadSearchDivAjax(param){ var url='';
 * 
 * if(param==1){ url='/referralSearch'; }else{ url='/contactSearch'; }
 * 
 * $.get(url, function(data, status){ $('#searchDataDiv').html(data); });
 *  }
 */

function getCurDateTime() {
	var today = new Date();
	var dd = today.getDate();

	var mm = today.getMonth() + 1;
	var yyyy = today.getFullYear();
	var hh = today.getHours();
	var min = today.getMinutes();
	if (dd < 10) {
		dd = '0' + dd;
	}

	if (mm < 10) {
		mm = '0' + mm;
	}

	if (hh < 10) {
		hh = '0' + hh;
	}
	if (min < 10) {
		min = '0' + min;
	}
	return dd+'/'+mm+'/'+yyyy+' '+hh+':'+min;
}

function submitFormFromEmpSearch(pageid,id,actionUrl) {

	var formId = '';
	var submitUrl =actionUrl
	//alert(''+pageid);
	//alert(id);
	//alert(actionUrl);

	if (pageid == 1) {
		formId = 'rental_form';
//		submitUrl = '/rentalForm';
	} else if (pageid == 2) {
		formId = 'sale_form';
//		submitUrl = '/saleForm';
	} else if (pageid == 3) {
		formId = 'matrimony_form';
//		submitUrl = '/matrimonyRegister';
	}else{
		formId = 'contact_form';
	}
	var formBindParam = $("#" + formId).serialize();
	$.ajax({
		type : "post",
		data : formBindParam,
		url : submitUrl,
		success : function(data, status,xhr) {
			console.log(xhr.status);
			if(xhr.status==200){

				$("#emp_infobox").modal();
				$('#emp_infobox #emp_infobox_msg').text('Details updated successfully!')
				$('#emp_infobox .modal-header').removeClass('alert-danger').addClass('alert-success');

			}
		},
		error: function(XMLHttpRequest, textStatus, errorThrown) {
			$("#emp_infobox").modal();
			$('#emp_infobox #emp_infobox_msg').text('Issue in updating data, Please try again later!')
			$('#emp_infobox .modal-header').removeClass('alert-success').addClass('alert-danger');
		}
	});
}

function performContactSearch() {
	if ($('#contactCreateDateFrom').val().length > 0
			&& $('#contactCreateDateTo').val().length > 0
			&& validateDateRange($('#contactCreateDateFrom').val(), $(
					'#contactCreateDateTo').val())) {
		$('#contactsearch_form').submit();
	} else {
		$("#success-alert").alert();
		$("#success-alert").fadeTo(4000, 500).slideUp(500, function() {
			$("#success-alert").slideUp(500);
		});
	}

}

function validateDateRange(from,to){
	from = from.split('/');
	to = to.split('/');
	var fromDt = new Date(from[2],from[1],from[0]);
	var toDt = new Date(to[2],to[1],to[0]);

	var difference_ms = toDt - fromDt;
	var one_day=1000*60*60*24;
	var dayDiff =  Math.round(difference_ms/one_day); 

	if (fromDt <= toDt && dayDiff<=7) {
	       return true;
	   }else{
	       return false;
	   }
}

$("#aggreement_close_ico").click(function(){
    $('#agreementPickModel').modal('hide');
});