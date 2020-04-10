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
 * Locale: IT (Italian; Italiano)
 */
(function ($) {
	$.extend($.validator.messages, {
		required: "Campo obbligatorio.",
		remote: "Controlla questo campo.",
		email: "Inserisci un indirizzo email valido.",
		url: "Inserisci un indirizzo web valido.",
		date: "Inserisci una data valida.",
		dateISO: "Inserisci una data valida (ISO).",
		number: "Inserisci un numero valido.",
		digits: "Inserisci solo numeri.",
		creditcard: "Inserisci un numero di carta di credito valido.",
		equalTo: "Il valore non corrisponde.",
		accept: "Inserisci un valore con un&apos;estensione valida.",
		maxlength: $.validator.format("Non inserire pi&ugrave; di {0} caratteri."),
		minlength: $.validator.format("Inserisci almeno {0} caratteri."),
		rangelength: $.validator.format("Inserisci un valore compreso tra {0} e {1} caratteri."),
		range: $.validator.format("Inserisci un valore compreso tra {0} e {1}."),
		max: $.validator.format("Inserisci un valore minore o uguale a {0}."),
		min: $.validator.format("Inserisci un valore maggiore o uguale a {0}.")
	});
}(jQuery));