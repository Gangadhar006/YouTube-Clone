package com.youtube.user.serviceImpl;

import com.youtube.user.model.User;
import com.youtube.user.payload.request.SignInRequest;
import com.youtube.user.payload.request.SignUpRequest;
import com.youtube.user.payload.response.SignInResponse;
import com.youtube.user.payload.response.SignUpResponse;
import com.youtube.user.repository.IUserRepository;
import com.youtube.user.service.IJwtService;
import com.youtube.user.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.youtube.user.constant.AppConstants.INVALID_CREDENTIALS_MESSAGE;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {
    private final ModelMapper mapper;
    private final IUserRepository userRepo;
    private final IJwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    @Override
    public SignInResponse signin(SignInRequest signinRequest) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(signinRequest.getEmail(), signinRequest.getPassword()));
        String jwt;

        if (authentication.isAuthenticated())
            jwt = jwtService.generateToken(signinRequest.getEmail());
        else throw new UsernameNotFoundException(INVALID_CREDENTIALS_MESSAGE);

        return SignInResponse.builder()
                .token(jwt)
                .build();
    }

    @Override
    public SignUpResponse signup(SignUpRequest signupRequest) {
        String password = signupRequest.getPassword();
        User user = mapper.map(signupRequest, User.class);
        user.setPassword(passwordEncoder.encode(password));
        user = userRepo.save(user);
        return mapper.map(user, SignUpResponse.class);
    }
}
