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
 * Locale: MY (Malay; Melayu)
 */
(function ($) {
	$.extend($.validator.messages, {
		required: "Medan ini diperlukan.",
		remote: "Sila betulkan medan ini.",
		email: "Sila masukkan alamat emel yang betul.",
		url: "Sila masukkan URL yang betul.",
		date: "Sila masukkan tarikh yang betul.",
		dateISO: "Sila masukkan tarikh(ISO) yang betul.",
		number: "Sila masukkan nombor yang betul.",
		digits: "Sila masukkan nilai digit sahaja.",
		creditcard: "Sila masukkan nombor kredit kad yang betul.",
		equalTo: "Sila masukkan nilai yang sama semula.",
		accept: "Sila masukkan nilai yang telah diterima.",
		maxlength: $.validator.format("Sila masukkan nilai tidak lebih dari {0} aksara."),
		minlength: $.validator.format("Sila masukkan nilai sekurang-kurangnya {0} aksara."),
		rangelength: $.validator.format("Sila masukkan panjang nilai antara {0} dan {1} aksara."),
		range: $.validator.format("Sila masukkan nilai antara {0} dan {1} aksara."),
		max: $.validator.format("Sila masukkan nilai yang kurang atau sama dengan {0}."),
		min: $.validator.format("Sila masukkan nilai yang lebih atau sama dengan {0}.")
	});
}(jQuery));