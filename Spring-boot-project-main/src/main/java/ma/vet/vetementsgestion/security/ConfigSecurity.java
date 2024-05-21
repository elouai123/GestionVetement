package ma.vet.vetementsgestion.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configurable
@EnableWebSecurity
public class ConfigSecurity extends WebSecurityConfigurerAdapter {




    protected void configure(AuthenticationManagerBuilder auth) throws Exception{

        PasswordEncoder passwordEncoder = passwordEncoder();

        String encodesPWD = passwordEncoder.encode("1234");
        System.out.println(encodesPWD);


        auth.inMemoryAuthentication().withUser("user1").password(encodesPWD).roles("USER");
        auth.inMemoryAuthentication().withUser("user2").password(passwordEncoder.encode("1111")).roles("USER");
        auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder.encode("2222")).roles("ADMIN","USER");
    }


    protected void configure(HttpSecurity http) throws Exception{
        http.formLogin().defaultSuccessUrl("/");
        http.authorizeRequests().antMatchers("/","/available_vet","/available_acc","/error").permitAll();
        http.authorizeRequests().antMatchers("/deleteAccessoire/{id}","/editAccessoire/{id}","/asave","/deleteVetements/{id}","/editVetements/{id}","/save").hasRole("ADMIN");
        http.authorizeRequests().antMatchers("/webjars").permitAll();
        http.authorizeRequests().anyRequest().authenticated();

    }



    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


}
