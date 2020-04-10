/*******************************************************************************
 * Gridscape Solutions, Inc. - CONFIDENTIAL & PROPRIETARY
 * --------------------------
 * [2015] - [2020] Gridscape Solutions, Inc.
 * All Rights Reserved.
 *
 * NOTICE:  All information contained herein is, and remains
 * the property of Gridscape Solutions, Inc.
 * The intellectual and technical concepts contained
 * herein are proprietary to Gridscape Solutions, Inc.
 * and may be covered by U.S. and Foreign Patents,
 * patents in process, and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Gridscape Solutions.
 *******************************************************************************/
 
  
  
/*
 * Translated default messages for the jQuery validation plugin.
 * Locale: DA (Danish; dansk)
 */
(function ($) {
	$.extend($.validator.messages, {
		required: "Dette felt er påkrævet.",
		maxlength: $.validator.format("Indtast højst {0} tegn."),
		minlength: $.validator.format("Indtast mindst {0} tegn."),
		rangelength: $.validator.format("Indtast mindst {0} og højst {1} tegn."),
		email: "Indtast en gyldig email-adresse.",
		url: "Indtast en gyldig URL.",
		date: "Indtast en gyldig dato.",
		number: "Indtast et tal.",
		digits: "Indtast kun cifre.",
		equalTo: "Indtast den samme værdi igen.",
		range: $.validator.format("Angiv en værdi mellem {0} og {1}."),
		max: $.validator.format("Angiv en værdi der højst er {0}."),
		min: $.validator.format("Angiv en værdi der mindst er {0}."),
		creditcard: "Indtast et gyldigt kreditkortnummer."
	});
}(jQuery));