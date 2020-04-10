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
 * Locale: LV (Latvian; latviešu valoda)
 */
(function ($) {
	$.extend($.validator.messages, {
		required: "Šis lauks ir obligāts.",
		remote: "Lūdzu, pārbaudiet šo lauku.",
		email: "Lūdzu, ievadiet derīgu e-pasta adresi.",
		url: "Lūdzu, ievadiet derīgu URL adresi.",
		date: "Lūdzu, ievadiet derīgu datumu.",
		dateISO: "Lūdzu, ievadiet derīgu datumu (ISO).",
		number: "Lūdzu, ievadiet derīgu numuru.",
		digits: "Lūdzu, ievadiet tikai ciparus.",
		creditcard: "Lūdzu, ievadiet derīgu kredītkartes numuru.",
		equalTo: "Lūdzu, ievadiet to pašu vēlreiz.",
		accept: "Lūdzu, ievadiet vērtību ar derīgu paplašinājumu.",
		maxlength: $.validator.format("Lūdzu, ievadiet ne vairāk kā {0} rakstzīmes."),
		minlength: $.validator.format("Lūdzu, ievadiet vismaz {0} rakstzīmes."),
		rangelength: $.validator.format("Lūdzu ievadiet {0} līdz {1} rakstzīmes."),
		range: $.validator.format("Lūdzu, ievadiet skaitli no {0} līdz {1}."),
		max: $.validator.format("Lūdzu, ievadiet skaitli, kurš ir mazāks vai vienāds ar {0}."),
		min: $.validator.format("Lūdzu, ievadiet skaitli, kurš ir lielāks vai vienāds ar {0}.")
	});
}(jQuery));