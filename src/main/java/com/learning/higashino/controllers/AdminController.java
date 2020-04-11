package com.learning.higashino.controllers;

import com.learning.higashino.components.ItemMaster;
import com.learning.higashino.services.AdminService;
import com.learning.higashino.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * 管理画面コントローラー
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    /**
     * adminServiceクラス
     */
    @Autowired
    AdminService adminService;

    /**
     * Topページ表示
     *
     * @return 管理画面Topページ
     */
    @RequestMapping(value = "")
    public String index() {
        return "admin/index";
    }

    /**
     * 商品登録 入力フォーム表示
     *
     * @param model SpringFramework Model
     * @return 管理画面商品登録入力フォームページ
     */
    @RequestMapping(value = "/register/item/form")
    public String registerItemForm(Model model) {
        model.addAttribute("item_form", new ItemMaster());
        return "admin/register/item/form";
    }

    /**
     * 商品登録 入力内容確認画面表示
     *
     * @param model                  SpringFramework Model
     * @param registerItemMasterForm フォーム入力内容
     * @param itemImage              商品画像
     * @return 管理画面商品登録入力内容確認ページ
     */
    @RequestMapping(value = "/register/item/confirm", method = RequestMethod.POST)
    public String registerItemConfirm(Model model, @ModelAttribute ItemMaster registerItemMasterForm, @RequestParam("item_image") MultipartFile itemImage) {
        try {
            registerItemMasterForm.setImageCode(FileUtil.getBinaryCode(itemImage));
            model.addAttribute("item_model", registerItemMasterForm);
            return "admin/register/item/confirm";
        } catch (Exception e) {
            model.addAttribute("error_msg", e.getStackTrace());
            return "error/500_server_error";
        }
    }

    /**
     * 商品登録 登録完了画面表示
     *
     * @param model                  SpringFramework Model
     * @param registerItemMasterInfo フォーム入力内容
     * @return 管理画面商品登録完了ページ
     */
    @RequestMapping(value = "/register/item/complete", method = RequestMethod.POST)
    public String registerItemComplete(Model model, @ModelAttribute ItemMaster registerItemMasterInfo) {
        try {
            adminService.insertItemMasterInfo(registerItemMasterInfo);
            return "admin/register/item/complete";
        } catch (Exception e) {
            model.addAttribute("error_msg", e.getStackTrace());
            return "error/500_server_error";
        }
    }

    /**
     * TODO データ確認用で作っただけ(商品情報のID=1のデータを表示する)
     */
    @RequestMapping(value = "/register/item/kakunin", method = RequestMethod.GET)
    public String registerItemKakunin(Model model) {
        try {
            model.addAttribute("item_model", adminService.getTopItemMasterInfo());
            return "admin/register/item/confirm";
        } catch (Exception e) {
            model.addAttribute("error_msg", e.getStackTrace());
            return "error/500_server_error";
        }
    }
}
