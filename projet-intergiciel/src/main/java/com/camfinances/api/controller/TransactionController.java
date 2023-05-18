package com.camfinances.api.controller;


import java.util.Optional;


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

@RestController
public class TransactionController {
    
    @Autowired
    private TransactionService transactionService;

    /**
     * Create - Add a new Transaction
     * 
     * @param transaction An object Transaction
     * @return The Transaction object saved
     */
    @PostMapping("/transaction")
    public Transaction createTransaction(@RequestBody Transaction transaction) {
        return transactionService.saveTransaction(transaction);
    }

    /**
     * Read - Get one Transaction
     * 
     * @param id The id of the Transaction
     * @return An Transaction object full filled
     */
    @GetMapping("/transaction/{id}")
    public Transaction getTransaction(@PathVariable("id") final Long id) {
        Optional<Transaction> transaction = transactionService.getTransaction(id);
        if (transaction.isPresent()) {
            return transaction.get();
        } else {
            return null;
        }

		
    }

    /**
     * Read - Get all Transactions
     * 
     * @return - An Iterable object of Transaction full filled
     */
    @GetMapping("/transactions")
    public Iterable<Transaction> getTransactions(HttpServletRequest req) {
        
		return transactionService.getTransactions();
		// Iterable<Transaction> transactions = transactionService.getTransactions(); 
		// ModelAndView mav = new ModelAndView("list");
		
		// mav.addObject("transactions", transactions);

		// return mav ;
    }


    /**
	 * Update - Update an existing Transaction
	 * @param id - The id of the Transaction to update
	 * @param Transaction - The Transaction object updated
	 * @return
	 */
	@PutMapping("/transaction/{id}")
	public Transaction updateTransaction(@PathVariable("id") final Long id, @RequestBody Transaction transaction) {
		Optional<Transaction> t = transactionService.getTransaction(id);
		if(t.isPresent()) {
			Transaction currentTransaction = t.get();
			
			String emetteur = transaction.getEmetteur();
			if(emetteur != null) {
				currentTransaction.setEmetteur(emetteur);
			}
			String recepteur = transaction.getRecepteur();
			if(recepteur != null) {
				currentTransaction.setRecepteur(recepteur);
			}
			Long montant = transaction.getMontant();
			if(montant != null) {
				currentTransaction.setMontant(montant);
			}

			String devise = transaction.getDevise();
			if(devise != null) {
				currentTransaction.setDevise(devise);
			}

            String question = transaction.getQuestion();
			if(question != null) {
				currentTransaction.setQuestion(question);
			}

            String reponse = transaction.getReponse();
			if(reponse != null) {
				currentTransaction.setReponse(reponse);
			}

            User user = transaction.getUser();
			if(user != null) {
				currentTransaction.setUser(user);
			}

			transactionService.saveTransaction(currentTransaction);
			return currentTransaction;
		} else {
			return null;
		}
	}

    @DeleteMapping("/transaction")
	public void deleteTransaction(@RequestParam("id") Long id) {
		transactionService.deleteTransaction(id);
	}



}
