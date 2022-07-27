import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONObject;

public class CreateAccount {

  public static ArrayList<AccountInterface> createAccount (JSONObject json, short count) {

    final ArrayList<AccountInterface> accountNumberList = new ArrayList<AccountInterface>();

    for(int i = 0; i < count; i++) {

      final int counter = i + 1;
      System.out.println("opening account on loop " + counter);
      final HashMap<String, String> credentialsMap = new HashMap<String, String>();
      final String accountNameKey = AccountCredentialHashMapKeys.accountName.name();
      final String accountTypeKey = AccountCredentialHashMapKeys.accountType.name();
      final String phoneNumberKey = AccountCredentialHashMapKeys.phoneNumber.name();

      final String accountName = (String) json.get(accountNameKey);
      final String accountType = AccountTypes.SAVINGS.name();//(String) json.get(accountTypeKey);
      final String phoneNumber = (String) json.get(phoneNumberKey);

      credentialsMap.put(accountNameKey, accountName + "_" + counter);
      credentialsMap.put(accountTypeKey, accountType);
      credentialsMap.put(phoneNumberKey, phoneNumber);
      
      Account account = new Account(credentialsMap);
      
      if (account.isOpened) {
        System.out.println("account name: " + account.accountName);
        System.out.println("account number: " + account.accountNumber);
        System.out.println("phone number: " + account.phoneNumber);
        accountNumberList.add(account);
      }
    }
    System.out.println("accounts opened in request: " + accountNumberList);
    return accountNumberList;
  }
}