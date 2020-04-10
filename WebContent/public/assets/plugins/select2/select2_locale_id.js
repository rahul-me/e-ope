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
 
  
  
/**
 * Select2 Indonesian translation.
 * 
 * Author: Ibrahim Yusuf <ibrahim7usuf@gmail.com>
 */
(function ($) {
    "use strict";

    $.extend($.fn.select2.defaults, {
        formatNoMatches: function () { return "Tidak ada data yang sesuai"; },
        formatInputTooShort: function (input, min) { var n = min - input.length; return "Masukkan " + n + " huruf lagi" + (n == 1 ? "" : "s"); },
        formatInputTooLong: function (input, max) { var n = input.length - max; return "Hapus " + n + " huruf" + (n == 1 ? "" : "s"); },
        formatSelectionTooBig: function (limit) { return "Anda hanya dapat memilih " + limit + " pilihan" + (limit == 1 ? "" : "s"); },
        formatLoadMore: function (pageNumber) { return "Mengambil data..."; },
        formatSearching: function () { return "Mencari..."; }
    });
})(jQuery);
