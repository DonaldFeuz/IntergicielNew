package com.camfinances.api.controller;


import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import com.camfinances.api.model.Transaction;
import com.camfinances.api.model.User;
import javax.servlet.http.HttpServletRequest;
import com.camfinances.api.service.TransactionService;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewController {


    @Autowired
    private TransactionService transactionService;

    /**
     * Create - Add a new Transaction
     * 
     * @param transaction An object Transaction
     * @return The Transaction object saved
     */
    @GetMapping("/transact")
    public String getTransactions(HttpServletRequest req, Model model) {
        // return transactionService.getTransactions();
		Iterable<Transaction> transactions = transactionService.getTransactions(); 
		// ModelAndView mav = new ModelAndView("list");
		
		model.addAttribute("transactions", transactions);

		return "transactions/liste" ;
    }


    
}
