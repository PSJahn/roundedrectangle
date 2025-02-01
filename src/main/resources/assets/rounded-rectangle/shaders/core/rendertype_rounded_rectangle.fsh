#version 330

uniform vec4 Bounds;
uniform float Radius;
uniform float Smoothness;

in vec4 vertexColor;

out vec4 fragColor;

float roundedBoxSDF(vec2 center, vec2 size, float radius) {
	return length(max(abs(center)- size + radius, 0.0))- radius;
}

void main() {
	vec2 fromXY = Bounds.xy;
	vec2 toXY = Bounds.zw;
	vec2 size = (toXY-fromXY) * 0.5f;

	float distance = roundedBoxSDF(gl_FragCoord.xy - fromXY - size, size, Radius);
    
	float smoothedAlpha = 1.0f-smoothstep(0.0f, Smoothness,distance);
	
	fragColor = vec4(vertexColor.rgb,vertexColor.a*smoothedAlpha);
}
