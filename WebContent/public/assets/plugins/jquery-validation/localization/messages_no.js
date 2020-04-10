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
 * Locale: NO (Norwegian; Norsk)
 */
(function ($) {
	$.extend($.validator.messages, {
		required: "Dette feltet er obligatorisk.",
		maxlength: $.validator.format("Maksimalt {0} tegn."),
		minlength: $.validator.format("Minimum {0} tegn."),
		rangelength: $.validator.format("Angi minimum {0} og maksimum {1} tegn."),
		email: "Oppgi en gyldig epostadresse.",
		url: "Angi en gyldig URL.",
		date: "Angi en gyldig dato.",
		dateISO: "Angi en gyldig dato (&ARING;&ARING;&ARING;&ARING;-MM-DD).",
		dateSE: "Angi en gyldig dato.",
		number: "Angi et gyldig nummer.",
		numberSE: "Angi et gyldig nummer.",
		digits: "Skriv kun tall.",
		equalTo: "Skriv samme verdi igjen.",
		range: $.validator.format("Angi en verdi mellom {0} og {1}."),
		max: $.validator.format("Angi en verdi som er mindre eller lik {0}."),
		min: $.validator.format("Angi en verdi som er st&oslash;rre eller lik {0}."),
		creditcard: "Angi et gyldig kredittkortnummer."
	});
}(jQuery));