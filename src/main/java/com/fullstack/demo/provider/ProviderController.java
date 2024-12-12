package com.fullstack.demo.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/providers")
public class ProviderController {

    @Autowired
    private ProviderService providerService;

    @GetMapping("/all")
    public String getAllProviders(Model model) {
        model.addAttribute("providers", providerService.getAllProviders());
        return "Provider-list";
    }

    @GetMapping("/view/{id}")
    public String viewProvider(@PathVariable("id") int id, Model model) {
        Provider provider = providerService.getProviderById(id);
        model.addAttribute("provider", provider);
        return "Provider-details";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        Provider provider = providerService.getProviderById(id);
        model.addAttribute("provider", provider);
        return "Provider-update";
    }

    @GetMapping("/new")
    public String showCreateProviderForm(Model model) {
        model.addAttribute("provider", new Provider());
        return "Provider-create";
    }

    @PostMapping("/new")
    public String addProvider(@ModelAttribute Provider provider) {
        providerService.addProvider(provider);
        return "redirect:/api/providers/all";
    }

    @PostMapping("/update")
    public String updateProvider(@ModelAttribute Provider provider) {
        providerService.updateProvider(provider.getProviderId(), provider);
        return "redirect:/api/providers/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteProvider(@PathVariable("id") int id) {
        providerService.deleteProvider(id);
        return "redirect:/api/providers/all";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "Provider-login";
    }

    @PostMapping("/login")
    public String loginProvider(@RequestParam String email, @RequestParam String password, Model model) {
        Provider provider = providerService.loginProvider(email, password);
        if (provider != null) {
            model.addAttribute("provider", provider);
            return "redirect:/api/providers/view/" + provider.getProviderId();
        } else {
            model.addAttribute("loginError", "Error logging in. Please try again.");
            return "Provider-login";
        }
    }
}
