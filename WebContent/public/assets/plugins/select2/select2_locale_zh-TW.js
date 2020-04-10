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
 * Select2 Traditional Chinese translation
 */
(function ($) {
    "use strict";
    $.extend($.fn.select2.defaults, {
        formatNoMatches: function () { return "沒有找到相符的項目"; },
        formatInputTooShort: function (input, min) { var n = min - input.length; return "請再輸入" + n + "個字元";},
        formatInputTooLong: function (input, max) { var n = input.length - max; return "請刪掉" + n + "個字元";},
        formatSelectionTooBig: function (limit) { return "你只能選擇最多" + limit + "項"; },
        formatLoadMore: function (pageNumber) { return "載入中..."; },
        formatSearching: function () { return "搜尋中..."; }
    });
})(jQuery);
