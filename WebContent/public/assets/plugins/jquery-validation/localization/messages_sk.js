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
 * Locale: SK (Slovak; slovenčina, slovenský jazyk)
 */
(function ($) {
	$.extend($.validator.messages, {
		required: "Povinné zadať.",
		maxlength: $.validator.format("Maximálne {0} znakov."),
		minlength: $.validator.format("Minimálne {0} znakov."),
		rangelength: $.validator.format("Minimálne {0} a Maximálne {0} znakov."),
		email: "E-mailová adresa musí byť platná.",
		url: "URL musí byť platný.",
		date: "Musí byť dátum.",
		number: "Musí byť číslo.",
		digits: "Môže obsahovať iba číslice.",
		equalTo: "Dva hodnoty sa musia rovnať.",
		range: $.validator.format("Musí byť medzi {0} a {1}."),
		max: $.validator.format("Nemôže byť viac ako{0}."),
		min: $.validator.format("Nemôže byť menej ako{0}."),
		creditcard: "Číslo platobnej karty musí byť platné."
	});
}(jQuery));