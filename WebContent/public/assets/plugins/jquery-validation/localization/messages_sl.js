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
 * Language: SL (Slovenian; slovenski jezik)
 */
(function ($) {
	$.extend($.validator.messages, {
		required: "To polje je obvezno.",
		remote: "Prosimo popravite to polje.",
		email: "Prosimo vnesite veljaven email naslov.",
		url: "Prosimo vnesite veljaven URL naslov.",
		date: "Prosimo vnesite veljaven datum.",
		dateISO: "Prosimo vnesite veljaven ISO datum.",
		number: "Prosimo vnesite veljavno število.",
		digits: "Prosimo vnesite samo števila.",
		creditcard: "Prosimo vnesite veljavno številko kreditne kartice.",
		equalTo: "Prosimo ponovno vnesite vrednost.",
		accept: "Prosimo vnesite vrednost z veljavno končnico.",
		maxlength: $.validator.format("Prosimo vnesite največ {0} znakov."),
		minlength: $.validator.format("Prosimo vnesite najmanj {0} znakov."),
		rangelength: $.validator.format("Prosimo vnesite najmanj {0} in največ {1} znakov."),
		range: $.validator.format("Prosimo vnesite vrednost med {0} in {1}."),
		max: $.validator.format("Prosimo vnesite vrednost manjše ali enako {0}."),
		min: $.validator.format("Prosimo vnesite vrednost večje ali enako {0}.")
	});
}(jQuery));