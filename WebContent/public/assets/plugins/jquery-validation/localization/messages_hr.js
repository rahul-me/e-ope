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
 * Locale: HR (Croatia; hrvatski jezik)
 */
(function ($) {
	$.extend($.validator.messages, {
		required: "Ovo polje je obavezno.",
		remote: "Ovo polje treba popraviti.",
		email: "Unesite ispravnu e-mail adresu.",
		url: "Unesite ispravan URL.",
		date: "Unesite ispravan datum.",
		dateISO: "Unesite ispravan datum (ISO).",
		number: "Unesite ispravan broj.",
		digits: "Unesite samo brojeve.",
		creditcard: "Unesite ispravan broj kreditne kartice.",
		equalTo: "Unesite ponovo istu vrijednost.",
		accept: "Unesite vrijednost sa ispravnom ekstenzijom.",
		maxlength: $.validator.format("Maksimalni broj znakova je {0} ."),
		minlength: $.validator.format("Minimalni broj znakova je {0} ."),
		rangelength: $.validator.format("Unesite vrijednost između {0} i {1} znakova."),
		range: $.validator.format("Unesite vrijednost između {0} i {1}."),
		max: $.validator.format("Unesite vrijednost manju ili jednaku {0}."),
		min: $.validator.format("Unesite vrijednost veću ili jednaku {0}.")
	});
}(jQuery));