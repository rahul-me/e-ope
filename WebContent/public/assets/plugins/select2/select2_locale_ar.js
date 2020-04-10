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
 * Select2 Arabic translation.
 * 
 * Author: Your Name <amedhat3@gmail.com>
 */
(function ($) {
    "use strict";

    $.extend($.fn.select2.defaults, {
        formatNoMatches: function () { return "لا توجد نتائج"; },
        formatInputTooShort: function (input, min) { var n = min - input.length; return "من فضلك أدخل " + n + " حروف أكثر"; },
        formatInputTooLong: function (input, max) { var n = input.length - max; return "من فضلك أحذف  " + n + " حروف"; },
        formatSelectionTooBig: function (limit) { return "يمكنك ان تختار " + limit + " أختيارات فقط"; },
        formatLoadMore: function (pageNumber) { return "تحمل المذيد من النتائج ..."; },
        formatSearching: function () { return "جاري البحث ..."; }
    });
})(jQuery);
